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
    private final BufferedImage image;

    public Blank() {
        this.id = "x";
        // do image
        BufferedImage _image;
        try {
            _image = ImageIO.read(new File("src/main/resources/blank.png"));
        } catch (IOException exception) {
            System.out.println("ERROR LOADING PIECE - TRAVIS PLEASE : " + exception);
            _image = null;
        }
        this.image = _image;
    }

    public Blank(String id) {
        this.id = id;
        // do image
        BufferedImage _image;
        try {
            _image = ImageIO.read(new File("src/main/resources/blank.png"));
        } catch (IOException exception) {
            System.out.println("ERROR LOADING PIECE - TRAVIS PLEASE : " + exception);
            _image = null;
        }
        this.image = _image;
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
