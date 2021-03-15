package me.travis.gol.gui;

import me.travis.gol.GameOfLife;

import javax.swing.*;

public class GameInfo extends JLabel {

    public GameInfo() {
        super("Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()), JLabel.CENTER);
        this.setBounds(GameOfLife.PLANE.getY() * 40 + 80, 400, 100, 20);
        this.setVisible(true);;
    }

    public void updateInfo() {
        this.setText("Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()));
    }

    public void resetInfo() {
        GameOfLife.ENGINE.resetTicks();
        this.setText("Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()));
    }

}
