package me.travis.gol.object.things;

import me.travis.gol.object.Obj;

public class Animal extends Obj {

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
    public String getId() {
        return "A";
    }

}
