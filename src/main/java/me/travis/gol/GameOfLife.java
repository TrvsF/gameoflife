package me.travis.gol;

import me.travis.gol.game.Engine;
import me.travis.gol.gui.Window;
import me.travis.gol.plane.Plane;
import me.travis.gol.util.PlaneUtil;
import me.travis.gol.util.Util;

public class GameOfLife {

    public static final Engine ENGINE = new Engine(0);

    public static Window WINDOW;

    private static Plane p;

    public static void main(String[] args) {

        p = new Plane(20, 30);
        p.generateRandomPlane();
        PlaneUtil.printDebugPlane(p);

        setEngineTps();

        WINDOW = new Window();

        WINDOW.refresh(true);
        WINDOW.refresh(false);

    }

    public static void setEngineTps() {
        int ms = Util.tpsToMs(ENGINE.getTps()) > 0 ?  Util.tpsToMs(ENGINE.getTps()) : 1;
        ENGINE.getTimer().purge();
        ENGINE.getTimer().schedule(new Engine(0), 0, ms * 3);
    }

    public static Plane getPlane() {
        return p;
    }

}