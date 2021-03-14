package me.travis.gol.object.person;

import me.travis.gol.object.Obj;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Person extends Obj {

    private final int sex;
    private int daysWithoutShelter;
    private int age;

    public Person(int sex) {
        this.sex = sex;
        this.daysWithoutShelter = 0;
        this.age = 0;
    }

    public boolean isMan() {
        return this.sex == 1;
    }

    public boolean isWoman() {
        return this.sex == -1;
    }

    @Override
    public void tick() {
        this.daysWithoutShelter++;
        this.age++;
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
        return false;
    }

    @Override
    public String getId() {
        return "P";
    }

    @Override
    public BufferedImage getImage() {
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/person.png"));
        } catch (IOException exception) {
            System.out.println("ERROR LOADING PIECE - TRAVIS PLEASE : " + exception);
            img = null;
        }
        return img;
    }

}
