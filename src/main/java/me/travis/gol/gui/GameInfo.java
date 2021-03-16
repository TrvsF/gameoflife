package me.travis.gol.gui;

import me.travis.gol.GameOfLife;

import javax.swing.*;
import java.awt.*;

public class GameInfo extends JLabel {

    public GameInfo() {
        super("<html>Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()) + "<br>Running = " + (GameOfLife.ENGINE != null && GameOfLife.ENGINE.isRunning()) + "</html>", JLabel.CENTER);
        this.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 320, 100, 40);
        this.setForeground(Color.WHITE);
        this.setVisible(true);
    }

    public void updateInfo() {
        this.setText("<html>Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()) + "<br>Running = " + (GameOfLife.ENGINE != null && GameOfLife.ENGINE.isRunning()) + "</html>");
    }

    public void refreshInfo() {
        this.setText("<html>Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()) + "<br>Running = " + (GameOfLife.ENGINE != null && GameOfLife.ENGINE.isRunning()) + "</html>");
    }

}
