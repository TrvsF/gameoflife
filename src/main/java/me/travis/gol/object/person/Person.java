package me.travis.gol.object.person;

import me.travis.gol.object.Obj;

public class Person extends Obj {

    private final int sex;
    private int daysWithoutShelter;
    private int age;

    public Person(int sex) {
        this.sex = sex;
        this.daysWithoutShelter = 0;
        this.age = 0;
    }

    public void nextTick() {
        this.daysWithoutShelter++;
        this.age++;
    }

    public boolean isMan() {
        return this.sex == 1;
    }

    public boolean isWoman() {
        return this.sex == -1;
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
    public String getId() {
        return "P";
    }
}
