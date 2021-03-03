package me.travis.gol.plane;

import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.person.people.Builder;
import me.travis.gol.util.Util;

public class Plane {

    private Obj[][] plane;
    private int x;
    private int y;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
        this.initPlane(x, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void generateRandomPlane() {
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

    private void initPlane(int x, int y) {
        this.plane = new Obj[x][];
        for (int i = 0; i < y; i++) {
            this.plane[i] = new Obj[y];
            for (int j = 0; j < x; j++) {
                this.plane[i][j] = new Blank();
            }
        }
    }



}
