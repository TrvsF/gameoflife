package me.travis.gol.object;

public class Blank extends Obj {

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
        return false;
    }

    @Override
    public String getId() {
        return "x";
    }
}
