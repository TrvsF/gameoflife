package me.travis.gol;

import me.travis.gol.plane.Plane;
import me.travis.gol.util.PlaneUtil;

public class GameOfLife {

    public static void main(String[] args) {

        Plane p = new Plane(50, 50);
        p.generateRandomPlane();
        PlaneUtil.printDebugPlane(p);

    }

}