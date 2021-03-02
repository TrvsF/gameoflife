package me.travis.gol.object.person;

import me.travis.gol.object.Object;

public class Person extends Object {

    private final int sex;

    public Person(int sex) {
        this.sex = sex;
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
}
