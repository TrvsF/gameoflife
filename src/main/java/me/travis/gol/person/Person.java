package me.travis.gol.person;

public class Person {

    // 0 = dead
    // 1 = child
    // 2 = breeding
    // 3 = hunting
    // 4 = building
    // 5 = house
    private int state;

    public Person(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
