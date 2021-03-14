package me.travis.gol.object.things;

import me.travis.gol.object.Obj;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * House object
 * house is needed for people to survive for a long time
 * house effects all tiles in a radius of 3
 * houses needs adults nearby so they do no decay
 * houses decay if there is no contact for 8 ticks
 */
public class House extends Obj {

    private int decay;

    public void House() {
        this.decay = 8;
    }

    @Override
    public void tick() {
        this.decay--;
    }

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
    public boolean isDead() {
        return decay <= 0;
    }

    @Override
    public String getId() {
        return "H";
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
