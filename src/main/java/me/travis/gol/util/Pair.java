package me.travis.gol.util;

/*
 * pair class, holds 2 elements of any datatype
 */
public class Pair<E1, E2> {

    private final E1 element1;
    private final E2 element2;

    // creates a pair
    public static <e1, e2> Pair<e1, e2> create(e1 element1, e2 element2) {
        return new Pair<>(element1, element2);
    }

    public Pair(E1 element1, E2 element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public E1 getElement1() {
        return this.element1;
    }

    public E2 getElement2() {
        return this.element2;
    }


}
