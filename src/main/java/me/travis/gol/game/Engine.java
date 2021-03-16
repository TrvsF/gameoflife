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
    private int ticks;
    private int currentTps;
    private int tps;

    public Engine(int mode, int tps) {
        this.mode = mode;
        this.tps = tps;
        this.currentTps = tps;
        this.ticks = 0;
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

    public int getTicks() {
        return this.ticks;
    }

    public void resetTicks() {
        this.ticks = 0;
    }

    public void setCurrentTps(int tps) {
        this.currentTps = tps;
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
            // display
            GameOfLife.WINDOW.refresh(false);

            ticks++;

//            if (this.currentTps != this.tps) {
//                this.timer.cancel();
//                this.currentTps = this.tps;
//                double ms = Util.tpsToMs(this.getTps()) > 0.0 ? Util.tpsToMs(this.getTps()) : 1;
//                this.timer.schedule(this, 0, (int) ms);
//            }

        }
    }
}
