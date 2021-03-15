package me.travis.gol.game;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Obj;
import me.travis.gol.plane.PlaneCalculations;

import java.util.Timer;
import java.util.TimerTask;

/**
 * engine that runs the game
 */
public class Engine extends TimerTask {

    private final Timer timer;

    private boolean running;

    // 0 = classic
    // 1 = new
    private final int mode;
    private double tps;

    public Engine(int mode, double tps) {
        this.mode = mode;
        this.tps = tps;
        this.running = false;
        this.timer = new Timer();
    }

    public void toggle() {
        this.running = !this.running;
    }

    public void start() {
        this.running = true;
    }

    public boolean isRunning() {
        return this.running;
    }

    public int getMode() {
        return this.mode;
    }

    public double getTps() {
        return this.tps;
    }

    public void setTps(int tps) {
        this.tps = tps;
    }

    public Timer getTimer() {
        return this.timer;
    }

    /**
     * each tick this is ran to update the board
     */
    @Override
    public void run() {

        if (this.isRunning()) {
            // do next tick of game
            Obj[][] newBoard = PlaneCalculations.clonePlane(GameOfLife.PLANE.getPlane());
            for (int i = 0; i < GameOfLife.PLANE.getPlane().length; i++) {
                for (int j = 0; j < GameOfLife.PLANE.getPlane()[i].length; j++) {
                    PlaneCalculations.checkObj(i, j, newBoard);
                }
            }
            // update plane object
            GameOfLife.PLANE.setPlane(newBoard);
            // print in console
            PlaneCalculations.printDebugPlane(GameOfLife.PLANE);
            // display
            try {
                GameOfLife.WINDOW.refresh(false);
            } catch (Exception ignored) {}
        }

    }
}
