package me.travis.gol.object.things;

import me.travis.gol.object.Obj;
import me.travis.gol.util.Util;

public class Animal extends Obj {

    private int age;
    private boolean isDead;

    public Animal() {
        this.age = 0;
        this.isDead = false;
    }

    @Override
    public void tick() {
        this.age++;
        if (this.age > 4 && Util.getRandomInt(this.age, 12) % 2 == 0) {
            this.isDead = true;
        }
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public boolean canBreed() {
        return true;
    }

    @Override
    public boolean canDie() {
        return true;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public String getId() {
        return "A";
    }

}
