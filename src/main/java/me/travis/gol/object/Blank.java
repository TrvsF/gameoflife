package me.travis.gol.object;

import me.travis.gol.GameOfLife;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Blank object
 */
public class Blank extends Obj {

    private final String id;
    private final BufferedImage image;

    public Blank() {
        this.id = "x";
        this.image = GameOfLife.blankImage;
    }

    @Override
    public void tick() {}

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
    public boolean isDead() {
        return false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public BufferedImage getImage() {
        return this.image;
    }

}
