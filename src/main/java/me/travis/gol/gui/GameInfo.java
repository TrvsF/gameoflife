package me.travis.gol.gui;

import me.travis.gol.GameOfLife;
import me.travis.gol.plane.PlaneCalculations;
import me.travis.gol.util.Pair;

import javax.swing.*;
import java.awt.*;

public class GameInfo extends JLabel {

    public GameInfo() {
        Pair<Integer, Integer> aliveDeadCells = PlaneCalculations.getAliveDeadCells();
        this.setText("<html>" +
                "Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()) +
                "<br>Running : " + (GameOfLife.ENGINE != null && GameOfLife.ENGINE.isRunning()) +
                "<br>Alive Cells : " + aliveDeadCells.getElement1() +
                "<br>Dead Cells : " + aliveDeadCells.getElement2() +
                "<br>Born Cells : " + PlaneCalculations.cellsThatHaveBorn +
                "<br>Died Cells : " + PlaneCalculations.cellsThatHaveDied +
                "</html>");
        this.setBounds(GameOfLife.PLANE.getY() * 15 + 80, 320, 120, 120);
        this.setForeground(Color.WHITE);
        this.setVisible(true);
    }

    public void updateInfo() {
        Pair<Integer, Integer> aliveDeadCells = PlaneCalculations.getAliveDeadCells();
        this.setText("<html>" +
                "Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()) +
                "<br>Running : " + (GameOfLife.ENGINE != null && GameOfLife.ENGINE.isRunning()) +
                "<br>Alive Cells : " + aliveDeadCells.getElement1() +
                "<br>Dead Cells : " + aliveDeadCells.getElement2() +
                "<br>Born Cells : " + PlaneCalculations.cellsThatHaveBorn +
                "<br>Died Cells : " + PlaneCalculations.cellsThatHaveDied +
                "</html>");
    }

    public void refreshInfo(boolean toggle) {
        if (!toggle) {
            PlaneCalculations.resetStats();
        }
        Pair<Integer, Integer> aliveDeadCells = PlaneCalculations.getAliveDeadCells();
        this.setText("<html>" +
                "Ticks : " + (GameOfLife.ENGINE == null ? "0" : GameOfLife.ENGINE.getTicks()) +
                "<br>Running : " + (GameOfLife.ENGINE != null && GameOfLife.ENGINE.isRunning()) +
                "<br>Alive Cells : " + aliveDeadCells.getElement1() +
                "<br>Dead Cells : " + aliveDeadCells.getElement2() +
                "<br>Born Cells : " + PlaneCalculations.cellsThatHaveBorn +
                "<br>Died Cells : " + PlaneCalculations.cellsThatHaveDied +
                "</html>");
    }

}
