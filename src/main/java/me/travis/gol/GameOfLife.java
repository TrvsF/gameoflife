package me.travis.gol;

import me.travis.gol.game.Engine;
import me.travis.gol.plane.Plane;
import me.travis.gol.util.PlaneUtil;
import me.travis.gol.util.Util;

public class GameOfLife {

    private static final Engine ENGINE = new Engine();

    private static Plane p;

    public static void main(String[] args) {

        p = new Plane(20, 20);
        p.generateRandomPlane();
        PlaneUtil.printDebugPlane(p);

        setEngineTps();

    }

    public static void setEngineTps() {
        int ms = Util.tpsToMs(ENGINE.getTps()) > 0 ?  Util.tpsToMs(ENGINE.getTps()) : 1;
        ENGINE.getTimer().purge();
        ENGINE.getTimer().schedule(new Engine(), 0, ms);
    }

    public static Plane getPlane() {
        return p;
    }

}