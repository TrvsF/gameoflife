package me.travis.gol.plane;

import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.person.Person;
import me.travis.gol.object.person.people.Builder;
import me.travis.gol.util.Util;

public class Plane {

    private Obj[][] plane;
    private final int x;
    private final int y;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
        this.initPlane(x, y);
    }

    public Plane(int preset) {
        this.x = 11;
        this.y = 38;
        this.initPlane(x, y);
        initGosperGun();
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

    public void setPlane(Obj[][] plane) {
        this.plane = plane;
    }

    private void initPlane(int x, int y) {
        this.plane = new Obj[x][];
        for (int i = 0; i < x; i++) {
            this.plane[i] = new Obj[y];
            for (int j = 0; j < y; j++) {
                this.plane[i][j] = new Blank();
            }
        }
    }

    private void initGosperGun() {
        this.plane[6][1] = new Person(1);
        this.plane[6][2] = new Person(1);
        this.plane[5][1] = new Person(1);
        this.plane[5][2] = new Person(1);

        this.plane[8][3] = new Person(1);
        this.plane[8][4] = new Person(1);
        this.plane[7][3] = new Person(1);
        this.plane[7][4] = new Person(1);

        this.plane[4][35] = new Person(1);
        this.plane[4][36] = new Person(1);
        this.plane[3][35] = new Person(1);
        this.plane[3][36] = new Person(1);

        this.plane[5][10] = new Person(1);
        this.plane[6][10] = new Person(1);
        this.plane[7][10] = new Person(1);
    }



}
