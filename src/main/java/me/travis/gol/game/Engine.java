package me.travis.gol.game;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Obj;
import me.travis.gol.util.PlaneUtil;

import java.util.Timer;
import java.util.TimerTask;

public class Engine extends TimerTask {

    private final Timer timer;

    // 0 = classic
    // 1 = new
    private final int mode;
    private int tps;

    public Engine(int mode) {
        this.mode = mode;
        this.tps = 1;
        this.timer = new Timer();
    }

    public int getMode() {
        return this.mode;
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
        Obj[][] newBoard = PlaneUtil.clonePlane(GameOfLife.getPlane().getPlane());
        for (int i = 0; i < GameOfLife.getPlane().getPlane().length; i++) {
            for (int j = 0; j < GameOfLife.getPlane().getPlane()[i].length; j++) {
                PlaneUtil.checkObj(i, j, newBoard);
            }
        }
        GameOfLife.getPlane().setPlane(newBoard);

        PlaneUtil.printDebugPlane(GameOfLife.getPlane());
        try {
            GameOfLife.WINDOW.refresh(false);
        } catch (Exception ignored) {}

    }
}
