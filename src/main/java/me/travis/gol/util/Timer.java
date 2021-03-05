package me.travis.gol.util;

public class Timer {

    private long time;

    public Timer() {
        this.time = System.nanoTime();
    }

    public boolean passed(long ms) {
        return this.getTime(System.nanoTime() - this.time) >= ms;
    }

    public void reset() {
        this.time = System.nanoTime();
    }

    public long getTime(long time) {
        return time / 1000000L;
    }

}
