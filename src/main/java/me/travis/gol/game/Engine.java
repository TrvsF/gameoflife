package me.travis.gol.game;

import java.util.Timer;
import java.util.TimerTask;

public class Engine extends TimerTask {

    private final Timer timer;
    private int tps;

    public Engine() {
        this.tps = 2;
        this.timer = new Timer();
    }

    public int getTps() {
        return this.tps;
    }

    public void setTps(int tps) {
        this.tps = tps;
    }

    public Timer getTimer() {
        return this.timer;
    }

    @Override
    public void run() {
        System.out.print("hello there");
    }
}
