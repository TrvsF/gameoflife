package me.travis.gol.util;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.person.Person;
import me.travis.gol.plane.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneUtil {

    /**
     * prints a given plane in debug mode
     * @param plane Given plane
     */
    public static void printDebugPlane(Plane plane) {
        for (int i = 0; i < plane.getX(); i++) {
            System.out.print(i + 1 + (i > 9 ? " " : "  "));
        }
        System.out.print("\n");

        for (int i = 0; i < plane.getPlane().length; i++) {
            System.out.print(i + 1 + (i > 9 ? " " : "  "));
            for (int j = 0; j < plane.getPlane()[i].length; j++) {
                System.out.print(plane.getPlane()[i][j].getId() + ("  "));
            }
            System.out.print("\n");
        }
    }

    public static void checkObj(int x, int y) {
        Obj o = GameOfLife.getPlane().getPlane()[x][y];

        if (o instanceof Blank) return;

        if (o instanceof Person) {
            o.tick();
            moveRandomDirection(1, x, y);
        }

        if (o.isDead()) {
            GameOfLife.getPlane().getPlane()[x][y] = new Blank();
        }

    }

    private static void moveRandomDirection(int radius, int x, int y) {
        List<Pair<Integer, Integer>> validMoves = new ArrayList<>();

        // collect all valid moves
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if ((i == 0 && j == 0) || isOOB(x + i, y + j)) continue; // don't care if OOB or is own object
                if (GameOfLife.getPlane().getPlane()[x + i][y + j] instanceof Blank) {
                    validMoves.add(Pair.create(x + i, y + j));
                }
            }
        }

        if (validMoves.isEmpty()) return; // no valid moves found

        // move the object and replace with a blank
        Pair<Integer, Integer> p = validMoves.get(Util.getRandomListIndex(validMoves));
        GameOfLife.getPlane().getPlane()[p.getElement1()][p.getElement2()] = GameOfLife.getPlane().getPlane()[x][y];
        GameOfLife.getPlane().getPlane()[x][y] = new Blank();
    }

    private static List<Obj> getNearby(int x, int y, int radius) {
        List<Obj> objs = new ArrayList<>();

        for (int i = -radius; i < radius; i++) {
            for (int j = -radius; j < radius; j++) {
                if ((i == 0 && j == 0) || isOOB(x + i, y + j)) continue; // don't care if OOB or is own object
                objs.add(GameOfLife.getPlane().getPlane()[x + i][y + j]);
            }
        }

        return objs;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || y < 0 || x >= GameOfLife.getPlane().getX() || y >= GameOfLife.getPlane().getY();
    }

}
