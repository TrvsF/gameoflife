package me.travis.gol.game;

import me.travis.gol.GameOfLife;
import me.travis.gol.util.PlaneUtil;

import java.util.Timer;
import java.util.TimerTask;

public class Engine extends TimerTask {

    private final Timer timer;
    private int tps;

    public Engine() {
        this.tps = 1;
        this.timer = new Timer();
    }

    public int getTps() {
        return this.tps;
    }

    public void setTps(int tps) {
        this.tps = tps;
        GameOfLife.setEngineTps();
    }

    public Timer getTimer() {
        return this.timer;
    }

    @Override
    public void run() {
        // System.out.print("hello there");

        for (int i = 0; i < GameOfLife.getPlane().getPlane().length; i++) {
            for (int j = 0; j < GameOfLife.getPlane().getPlane()[i].length; j++) {
                PlaneUtil.checkObj(i, j);
            }
        }

        PlaneUtil.printDebugPlane(GameOfLife.getPlane());

    }
}
