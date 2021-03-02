package me.travis.gol.object.things;

import me.travis.gol.object.Object;

public class House extends Object {

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean canBreed() {
        return false;
    }

    @Override
    public boolean canDie() {
        return true;
    }

}
