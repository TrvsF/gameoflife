package me.travis.gol;

import me.travis.gol.game.Engine;
import me.travis.gol.gui.Window;
import me.travis.gol.plane.Plane;
import me.travis.gol.plane.PlaneCalculations;
import me.travis.gol.util.Util;

public class GameOfLife {

    public static Engine ENGINE;

    public static Window WINDOW;

    public static Plane PLANE;

    public static void main(String[] args) {

        System.out.println("GENERATING PLANE...");
        PLANE = new Plane(22, 40);
        PLANE.generateRandomPlane();
        PlaneCalculations.printDebugPlane(PLANE);
        System.out.println("done");

        System.out.println("STARTING GUI...");
        WINDOW = new Window();
        WINDOW.refresh(true);
        WINDOW.refresh(false);
        System.out.println("done");

        System.out.println("STARTING GAME...");
        ENGINE = new Engine(0, .5);
        setEngineTps();
        ENGINE.start();
        System.out.println("Game running : "+ENGINE.isRunning());
        System.out.println("DONE");

    }

    public static void setEngineTps() {
        double ms = Util.tpsToMs(ENGINE.getTps()) > 0.0 ?  Util.tpsToMs(ENGINE.getTps()) : 1;
        ENGINE.getTimer().purge();
        ENGINE.getTimer().schedule(new Engine(0, ENGINE.getTps()), 0, (int) ms);
    }

}