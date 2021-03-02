package me.travis.gol.plane;

import me.travis.gol.person.Person;

public class Plane {

    private Person[][] plane;
    private int x;
    private int y;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
        this.initPlane(x, y);
    }

    public Person[][] getPlane() {
        return this.plane;
    }

    private void initPlane(int x, int y) {
        this.plane = new Person[x][];
        for (int i = 0; i < x; i++) {
            this.plane[i] = new Person[y];
            for (int j = 0; j < y; j++) {
                this.plane[i][j] = new Person(0);
            }
        }
    }

}
