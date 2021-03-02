package me.travis.gol.plane;

import me.travis.gol.object.Blank;

public class Plane {

    private Blank[][] plane;
    private int x;
    private int y;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
        this.initPlane(x, y);
    }

    public Blank[][] getPlane() {
        return this.plane;
    }

    private void initPlane(int x, int y) {
        this.plane = new Blank[x][];
        for (int i = 0; i < x; i++) {
            this.plane[i] = new Blank[y];
            for (int j = 0; j < y; j++) {
                this.plane[i][j] = new Blank();
            }
        }
    }

}
