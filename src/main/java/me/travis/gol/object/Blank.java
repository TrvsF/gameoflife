package me.travis.gol.object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Blank object
 */
public class Blank extends Obj {

    private final String id;

    public Blank() {
        this.id = "x";
    }

    public Blank(String id) {
        this.id = id;
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
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/blank.png"));
        } catch (IOException exception) {
            System.out.println("ERROR LOADING PIECE - TRAVIS PLEASE : " + exception);
            img = null;
        }
        return img;
    }
}
