package me.travis.gol.object.things;

import me.travis.gol.object.Obj;

public class House extends Obj {

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

    @Override
    public String getId() {
        return "H";
    }

}
