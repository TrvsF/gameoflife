package me.travis.gol.gui;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Obj;
import me.travis.gol.util.Util;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * window of gui, contains all gui elements
 */
public class Window extends JFrame {

    private final GameInfo gameInfo;

    private final ImageIcon ICON = new ImageIcon("src/main/resources/logo.png");

    // combo box init
    private final Integer[] dropDownItems = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final JComboBox<Integer> underCombo = new JComboBox<>(dropDownItems);
    private final JComboBox<Integer> overCombo = new JComboBox<>(dropDownItems);
    private final JComboBox<Integer> bornCombo = new JComboBox<>(dropDownItems);

    private final List<Square> squares = new ArrayList<>();

    private int sliderValue;

    private static final int SQUARE_START_X = 20;
    private static final int SQUARE_START_Y = 20;
    private static final int SQUARE_PADDING = 15;

    public Window() {
        this.initWindow();
        this.drawPlane();
        this.addToggleButton();
        this.addTpsSlider();
        this.addSaveButton();
        this.addLoadButton();
        this.addRandomiseButton();
        this.addClearButton();

        gameInfo = new GameInfo();
        this.add(gameInfo);

        this.initComboBoxes();
        this.add(underCombo);
        this.add(overCombo);
        this.add(bornCombo);
    }

    /**
     * inits the combo boxes to change the game rules
     */
    private void initComboBoxes() {
        underCombo.setSelectedItem(2);
        underCombo.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 460, 100, 30);
        underCombo.updateUI();
        JLabel value = new JLabel("Under Pop Value", JLabel.CENTER);
        value.setBounds(underCombo.getX(), underCombo.getY() - 20, 100, 20);
        this.add(value);

        overCombo.setSelectedItem(3);
        overCombo.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 520, 100, 30);
        overCombo.updateUI();
        JLabel value2 = new JLabel("Over Pop Value", JLabel.CENTER);
        value2.setBounds(underCombo.getX(), overCombo.getY() - 20, 100, 20);
        this.add(value2);

        bornCombo.setSelectedItem(3);
        bornCombo.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 580, 100, 30);
        bornCombo.updateUI();
        JLabel value3 = new JLabel("Born Pop Value", JLabel.CENTER);
        value3.setBounds(underCombo.getX(), bornCombo.getY() - 20, 100, 20);
        this.add(value3);
    }

    /**
     * inits window size and other attributes
     */
    private void initWindow() {
        this.setSize(GameOfLife.PLANE.getY() * 15 + 240, GameOfLife.PLANE.getX() * 15 + 65);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GameOfLife");
        this.getContentPane().setBackground(new Color(0x4F4F4F));
        this.setIconImage(ICON.getImage());
        this.setVisible(true);
    }

    /**
     * display game engine toggle button
     */
    private void addToggleButton() {
        JButton button = new JButton();
        button.setSize(100, 50);
        button.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 140, 100, 50);
        button.setText("toggle");
        button.setBackground(Color.WHITE);
        button.setVisible(true);
        this.add(button);
        // button listener
        button.addActionListener(e -> {
            GameOfLife.ENGINE.toggle();
            gameInfo.refreshInfo();
        });
    }

    /**
     * save the current plane
     */
    private void addSaveButton() {
        JButton button = new JButton();
        button.setSize(100, 50);
        button.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 20, 100, 50);
        button.setText("save");
        button.setBackground(Color.WHITE);
        button.setVisible(true);
        this.add(button);
        // button listener
        button.addActionListener(e -> {
            try {
                Util.savePlaneToFile(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            gameInfo.refreshInfo();
        });
    }

    /**
     * load a saved plane
     */
    private void addLoadButton() {
        JButton button = new JButton();
        button.setSize(100, 50);
        button.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 80, 100, 50);
        button.setText("load");
        button.setBackground(Color.WHITE);
        button.setVisible(true);
        this.add(button);
        // button listener
        button.addActionListener(e -> {
            if (GameOfLife.ENGINE.isRunning()) return;
            try {
                handleLoad();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            gameInfo.refreshInfo();
        });
    }

    /**
     * randomise the plane
     */
    private void addRandomiseButton() {
        JButton button = new JButton();
        button.setSize(100, 50);
        button.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 200, 100, 50);
        button.setText("randomise");
        button.setBackground(Color.WHITE);
        button.setVisible(true);
        this.add(button);
        // button listener
        button.addActionListener(e -> {
            if (GameOfLife.ENGINE.isRunning()) return;
            GameOfLife.PLANE.generateRandomPlane();
            redrawPlane();
            GameOfLife.ENGINE.resetTicks();
            gameInfo.refreshInfo();
        });
    }

    /**
     * clear the plane
     */
    private void addClearButton() {
        JButton button = new JButton();
        button.setSize(100, 50);
        button.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 260, 100, 50);
        button.setText("clear");
        button.setBackground(Color.WHITE);
        button.setVisible(true);
        this.add(button);
        // button listener
        button.addActionListener(e -> {
            if (GameOfLife.ENGINE.isRunning()) return;
            GameOfLife.PLANE.initPlane();
            redrawPlane();
        });
    }

    /**
     * handles the load function
     * @throws IOException E
     */
    private void handleLoad() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.print("Loading from : " + selectedFile.getAbsolutePath());
            Util.loadFile(selectedFile.getAbsolutePath());
        }
    }

    /**
     * slider to control the game speed
     */
    private void addTpsSlider() {
        JSlider slider = new JSlider(0, 10);
        slider.setValue(4);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 370, 100, 50);
        slider.setVisible(true);
        this.sliderValue = slider.getValue();
        this.add(slider);
        // slider value
        JLabel value = new JLabel("value : " + slider.getValue(), JLabel.CENTER);
        value.setBounds(slider.getX(), slider.getY() + 50, 100, 20);
        // slider listener
        slider.addChangeListener(e -> {
            value.setText("value : " + slider.getValue());
            GameOfLife.ENGINE.setTps(this.getSliderValue());
            if (GameOfLife.ENGINE.isRunning()) {
                GameOfLife.ENGINE.toggle(); // turn off engine
                GameOfLife.ENGINE.getTimer().cancel();
                GameOfLife.ENGINE.getTimer().purge();
                try {
                    GameOfLife.setEngineTps();
                } catch (Exception err) {
                    System.out.print("error setting timer : " + err);
                }
            }
        });
        this.add(value);
    }

    public void updateGameInfo() {
        this.gameInfo.updateInfo();
    }

    public int getSliderValue() {
        return this.sliderValue;
    }

    public int getUnderPop() {
        return (this.underCombo.getSelectedItem() == null ? 0 : (int) this.underCombo.getSelectedItem());
    }

    public int getOverPop() {
        return (this.overCombo.getSelectedItem() == null ? 0 : (int) this.overCombo.getSelectedItem());
    }

    public int getBornPop() {
        return (this.bornCombo.getSelectedItem() == null ? 0 : (int) this.bornCombo.getSelectedItem());
    }

    /**
     * draws the plane and the squares
     */
    private void drawPlane() {
        int x = SQUARE_START_X;
        int y = SQUARE_START_Y;

        for (Obj[] objs : GameOfLife.PLANE.getPlane()) {
            for (Obj obj : objs) {
                Square square = new Square(x, y, obj.getImage());
                this.add(square);
                this.squares.add(square);
                x += SQUARE_PADDING;
            }
            y += SQUARE_PADDING;
            x = SQUARE_START_X;
        }
    }

    /**
     * redraws the squares after game tick
     */
    private void redrawPlane() {
        if (this.squares.isEmpty()) return;

        int c = -1;
        for (Obj[] objs : GameOfLife.PLANE.getPlane()) {
            for (Obj obj : objs) {
                c++;
                if (this.squares.get(c).getImage() == obj.getImage()) continue; // speeeed
                this.squares.get(c).updateImage(obj.getImage());
                this.squares.get(c).repaint();
            }
        }
    }

    /**
     * refreshes the board
     * @param hard If should be hard refreshed (all elements removed and re-added)
     */
    public void refresh(boolean hard) {
        this.redrawPlane();
        this.updateGameInfo();
        if (hard) {
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

}
