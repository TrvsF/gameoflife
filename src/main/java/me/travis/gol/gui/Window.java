package me.travis.gol.gui;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Obj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * window of gui, contains all gui elements
 */
public class Window extends JFrame {

    private final ImageIcon ICON = new ImageIcon("src/main/resources/logo.png");

    private final List<Square> squares = new ArrayList<>();

    private static final int SQUARE_START_X = 40;
    private static final int SQUARE_START_Y = 40;
    private static final int SQUARE_PADDING = 40;

    public Window() {
        this.initWindow();
        this.drawPlane();
        this.addToggleButton();
        this.addTpsSlider();
    }

    /**
     * inits window size and other attributes
     */
    private void initWindow() {
        this.setSize(GameOfLife.PLANE.getY() * 40 + 240, GameOfLife.PLANE.getX() * 40 + 80);
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
        button.setSize(50, 50);
        button.setBounds(GameOfLife.PLANE.getY() * 40 + 80, 80, 100, 50);
        button.setText("toggle");
        button.setVisible(true);
        this.add(button);
    }

    private void addTpsSlider() {
        JSlider slider = new JSlider();
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(GameOfLife.PLANE.getY() * 40 + 80, 300, 100, 20);
        slider.setVisible(true);
        this.add(slider);
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
        if (hard) {
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

}
