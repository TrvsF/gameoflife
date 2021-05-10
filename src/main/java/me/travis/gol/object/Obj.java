package me.travis.gol.object;

import java.awt.image.BufferedImage;

/**
 * abstract object class, contains all needed functions for every object
 */
public abstract class Obj {
    /**
     * what the object should do each game tick
     */
    public abstract void tick();

    /**
     * @return if object can move
     */
    public abstract boolean canMove();

    /**
     * @return if object can breed
     */
    public abstract boolean canBreed();

    /**
     * @return if object can die
     */
    public abstract boolean canDie();

    /**
     * @return if object is dead
     */
    public abstract boolean isDead();

    /**
     * @return id of object
     */
    public abstract String getId();

    /**
     * @return image of object
     */
    public abstract BufferedImage getImage();

}
