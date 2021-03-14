package me.travis.gol.object;

import java.awt.image.BufferedImage;

public abstract class Obj {

    public abstract void tick();

    public abstract boolean canMove();

    public abstract boolean canBreed();

    public abstract boolean canDie();

    public abstract boolean isDead();

    public abstract String getId();

    public abstract BufferedImage getImage();

}
