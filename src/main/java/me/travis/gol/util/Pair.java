package me.travis.gol.util;

/*
 * tuple class, holds 3 elements of any datatype
 * (like a list or array but easy to use and more efficient)
 */
public class Pair<E1, E2> {

    private final E1 element1;
    private final E2 element2;

    // creates a tuple
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
