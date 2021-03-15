package me.travis.gol.gui;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Obj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {

    private final ImageIcon ICON = new ImageIcon("src/main/resources/logo.png");

    private final List<Square> squares = new ArrayList<>();

    private static final int SQUARE_START_X = 40;
    private static final int SQUARE_START_Y = 40;
    private static final int SQUARE_PADDING = 40;

    public Window() {
        this.initWindow();
        this.drawPlane();
    }

    private void initWindow() {
        this.setSize(GameOfLife.getPlane().getY() * 40 + 80, GameOfLife.getPlane().getX() * 40 + 80);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GameOfLife");
        this.getContentPane().setBackground(new Color(0x4F4F4F));
        this.setIconImage(ICON.getImage());
        this.setVisible(true);
    }

    private void drawPlane() {
        int x = SQUARE_START_X;
        int y = SQUARE_START_Y;

        for (Obj[] objs : GameOfLife.getPlane().getPlane()) {
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

    private void redrawPlane() {
        if (this.squares.isEmpty()) return;

        int c = 0;
        for (Obj[] objs : GameOfLife.getPlane().getPlane()) {
            for (Obj obj : objs) {
                this.squares.get(c).updateImage(obj.getImage());
                this.squares.get(c).repaint();
                c++;
            }
        }
    }

    public void refresh(boolean hard) {
        this.redrawPlane();
        if (hard) {
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

}
