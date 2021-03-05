package me.travis.gol.util;

import java.util.Random;

public class Util {

    private final static Random random = new Random();

    public static int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int tpsToMs(int tps) {
        return (1/tps) * 1000;
    }

}
