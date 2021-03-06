package me.travis.gol.util;

import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.things.House;
import me.travis.gol.plane.Plane;

public class PlaneUtil {

    public static void printDebugPlane(Plane plane) {
        for (int i = 0; i < plane.getX(); i++) {
            System.out.print(i + 1 + (i > 9 ? " " : "  "));
        }
        System.out.print("\n");

        for (int i = 0; i < plane.getPlane().length; i++) {
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < plane.getPlane()[i].length; j++) {
                System.out.print(plane.getPlane()[i][j].getId() + (j > 9 ? "  " : " "));
            }
            System.out.print("\n");
        }
    }

    public void checkObj(Plane plane, int x, int y) {
        Obj o = plane.getPlane()[x][y];

        if (o instanceof Blank) return;



    }

}
