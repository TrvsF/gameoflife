package me.travis.gol.plane;

import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.person.people.Builder;
import me.travis.gol.util.Util;

/**
 * Plane class, holds all info on a given plane
 */
public class Plane {

    private Obj[][] plane;

    private final int x;
    private final int y;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
        this.initPlane();
    }

    public Plane(Obj[][] plane) {
        this.x = plane.length;
        this.y = plane[0].length;
        this.plane = plane;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * generates a random plane, giving around 1 in 5 squares a person
     */
    public void generateRandomPlane() {
        this.initPlane();
        for (int i = 0; i < this.plane.length; i++) {
            for (int j = 0; j < this.plane[i].length; j++) {
                if (Util.getRandomInt(0, 5) == 0) {
                    this.plane[i][j] = new Builder(1);
                }
            }
        }
    }

    public Obj[][] getPlane() {
        return this.plane;
    }

    public void setPlane(Obj[][] plane) {
        this.plane = plane;
    }

    public void initPlane() {
        this.plane = new Obj[x][];
        for (int i = 0; i < x; i++) {
            this.plane[i] = new Obj[y];
            for (int j = 0; j < y; j++) {
                this.plane[i][j] = new Blank();
            }
        }
    }

}
