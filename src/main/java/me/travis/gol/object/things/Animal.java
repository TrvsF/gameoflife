package me.travis.gol.object.things;

import me.travis.gol.object.Object;

public class Animal extends Object {

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
