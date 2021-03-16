package me.travis.gol.object.things;

import me.travis.gol.object.Obj;
import me.travis.gol.util.Util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animal extends Obj {

    private int age;
    private boolean isDead;

    public Animal() {
        this.age = 0;
        this.isDead = false;
    }

    @Override
    public void tick() {
        this.age++;
        if (this.age > 4 && Util.getRandomInt(this.age, 12) % 2 == 0) {
            this.isDead = true;
        }
    }

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
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public String getId() {
        return "A";
    }

    @Override
    public BufferedImage getImage() {
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/blank.png"));
        } catch (IOException exception) {
            System.out.print("ERROR LOADING PIECE - TRAVIS PLEASE : " + exception);
            img = null;
        }
        return img;
    }

}
