package me.travis.gol.util;

import java.util.List;
import java.util.Random;

/**
 * basic util
 */
public class Util {

    private final static Random random = new Random();

    /**
     * returns a random int between 2 values
     * @param min Min value
     * @param max Max value
     * @return random int
     */
    public static int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * random index of a given list
     * @param l given list
     * @return random index (returns 0 if list is null)
     */
    public static int getRandomListIndex(List l) {
        if (l == null) return 0;
        return random.nextInt(l.size());
    }

    /**
     * converts tps to ms
     * @param tps Tps
     * @return ms
     */
    public static double tpsToMs(double tps) {
        return (1/tps) * 1000;
    }

}
