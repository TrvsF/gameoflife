package me.travis.gol.plane;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.person.Person;
import me.travis.gol.util.Pair;
import me.travis.gol.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * where all the calculations for the plane are done
 */
public class PlaneCalculations {

    public static int cellsThatHaveDied = 0;
    public static int cellsThatHaveBorn = 0;

    public static void resetStats() {
        cellsThatHaveBorn = 0;
        cellsThatHaveDied = 0;
    }

    /**
     * prints a given plane in debug mode
     * @param plane Given plane
     */
    public static void printDebugPlane(Plane plane) {
        System.out.print("\n");
        for (int i = 0; i < plane.getPlane().length; i++) {
            for (int j = 0; j < plane.getPlane()[i].length; j++) {
                System.out.print(plane.getPlane()[i][j].getId() + ("  "));
            }
            System.out.print("\n");
        }
    }

    public static void printDebugPlaneWithCoords(Plane plane) {
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

    /**
     * clones a plane so that a plane may be checked without disturbing the current plane
     * @param plane the plane to be cloned
     * @return a cloned plane
     */
    public static Obj[][] clonePlane(Obj[][] plane) {
        Obj[][] clone = new Obj[plane.length][];
        for (int i = 0; i < plane.length; i++) {
            clone[i] = new Obj[plane[i].length];
            System.arraycopy(plane[i], 0, clone[i], 0, clone[i].length);
        }
        return clone;
    }

    /**
     * checks a given object based on its x and y coords
     * @param x X of given object
     * @param y Y of given object
     * @param newBoard the board that should be updated if any calculations are made
     */
    public static void checkObj(int x, int y, Obj[][] newBoard) {
        if (GameOfLife.ENGINE.getMode() == 1) {
            checkObjNew(x, y);
        } else {
            checkObjClassic(x, y, newBoard);
        }
    }

    /**
     * checks the object for the classic game of life rules
     * @param x X of the given object
     * @param y Y of the given object
     * @param newBoard the board that should be updated if any calculations are made
     */
    private static void checkObjClassic(int x, int y, Obj[][] newBoard) {
        // object to be checked
        Obj o = GameOfLife.PLANE.getPlane()[x][y];

        // if object is blank
        if (o instanceof Blank) {
            int n = 0; // check if it has 3 neighbours, if so populate that square
            for (Obj _o : getNearby(x, y, 1)) {
                if (_o instanceof Person) {
                    n++;
                    if (n > GameOfLife.WINDOW.getBornPop()) break;
                }
            }
            if (n == GameOfLife.WINDOW.getBornPop()) { // new person
                newBoard[x][y] = new Person(Util.getRandomInt(0, 1));
                cellsThatHaveBorn++;
            }
        }

        // if object is a person
        if (o instanceof Person) {
            int n = 0; // check if is over/underpopulated, if so remove
            for (Obj _o : getNearby(x, y, 1)) {
                if (_o instanceof Person) {
                    n++;
                    if (n > GameOfLife.WINDOW.getOverPop()) break; // speed
                }
            }
            if (n < GameOfLife.WINDOW.getUnderPop() || n > GameOfLife.WINDOW.getOverPop()) {
                newBoard[x][y] = new Blank();
                cellsThatHaveDied++;
            }
        }
    }

    private static void checkObjNew(int x, int y) {
        Obj o = GameOfLife.PLANE.getPlane()[x][y];

        if (o instanceof Blank) return;

        if (o instanceof Person) {
            o.tick();
            moveRandomDirection(1, x, y);
        }

        if (o.isDead()) {
            GameOfLife.PLANE.getPlane()[x][y] = new Blank();
        }
    }

    private static void moveRandomDirection(int radius, int x, int y) {
        List<Pair<Integer, Integer>> validMoves = new ArrayList<>();

        // collect all valid moves
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if ((i == 0 && j == 0) || isOOB(x + i, y + j)) continue; // don't care if OOB or is own object
                if (GameOfLife.PLANE.getPlane()[x + i][y + j] instanceof Blank) {
                    validMoves.add(Pair.create(x + i, y + j));
                }
            }
        }

        if (validMoves.isEmpty()) return; // no valid moves found

        // move the object and replace with a blank
        Pair<Integer, Integer> p = validMoves.get(Util.getRandomListIndex(validMoves));
        GameOfLife.PLANE.getPlane()[p.getElement1()][p.getElement2()] = GameOfLife.PLANE.getPlane()[x][y];
        GameOfLife.PLANE.getPlane()[x][y] = new Blank();
    }

    /**
     * gets all objects surrounding a given coord in a given radius
     * @param x X of object to check
     * @param y Y of object to check
     * @param radius radius of object to check
     * @return List of all objects surrounding
     */
    private static List<Obj> getNearby(int x, int y, int radius) {
        List<Obj> objs = new ArrayList<>();

        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if ((i == 0 && j == 0) || isOOB(x + i, y + j)) continue; // don't care if OOB or is own object
                objs.add(GameOfLife.PLANE.getPlane()[x + i][y + j]);
            }
        }

        return objs;
    }

    /**
     * checks if given coord is out of bounds
     * @param x X coord
     * @param y Y coord
     * @return if the coord is out of bounds
     */
    private static boolean isOOB(int x, int y) {
        return x < 0 || y < 0 || x >= GameOfLife.PLANE.getX() || y >= GameOfLife.PLANE.getY();
    }

    public static Pair<Integer, Integer> getAliveDeadCells() {
        int aliveCells = 0;
        int deadCells = 0;
        for (Obj[] objs : GameOfLife.PLANE.getPlane()) {
            for (Obj obj : objs) {
                if (obj instanceof Blank) {
                    deadCells++;
                }
                if (obj instanceof Person) {
                    aliveCells++;
                }
            }
        }
        return Pair.create(aliveCells, deadCells);
    }

}
