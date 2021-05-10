package me.travis.gol;

import me.travis.gol.game.Engine;
import me.travis.gol.gui.Window;
import me.travis.gol.object.Obj;
import me.travis.gol.plane.Plane;
import me.travis.gol.util.Util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameOfLife {

    public static Engine ENGINE;

    public static Window WINDOW;

    public static Plane PLANE;

    public static ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    public static BufferedImage blankImage;
    public static BufferedImage personImage;

    public static void main(String[] args) {

        System.out.print("LOADING RESOURCES...");
        initImages();
        System.out.print("...DONE\n");

        System.out.print("GENERATING PLANE...");
        PLANE = new Plane(40, 70);
        PLANE.generateRandomPlane();
        System.out.print("...DONE\n");

        System.out.print("STARTING GUI...");
        WINDOW = new Window();
        WINDOW.refresh(true);
        WINDOW.refresh(false);
        System.out.print("...DONE\n");

        System.out.print("STARTING GAME ENGINE...");
        ENGINE = new Engine(0, 10);
        setEngineTps();
        System.out.print("...DONE\n");

        System.out.print("Initialised Conway's Game Of Life\n");

    }

    public static void refreshPlane(Obj[][] plane) {
        PLANE = new Plane(plane);
        WINDOW.refresh(false);
        ENGINE.resetTicks();
    }

    public static void setEngineTps() {
        double ms = Util.tpsToMs(ENGINE.getTps()) > 0.0 ?  Util.tpsToMs(ENGINE.getTps()) : 1; // dont want to divide by 0
        ENGINE.getTimer().purge();
        ENGINE.getTimer().schedule(ENGINE, 0, (int) ms);
    }

    public static void initImages() {
        BufferedImage _image;
        try {
            _image = ImageIO.read(Objects.requireNonNull(classLoader.getResource("person.png")));
        } catch (IOException exception) {
            System.out.print("ERROR LOADING PIECE - TRAVIS PLEASE : " + exception);
            _image = null;
        }
        personImage = _image;

        try {
            _image = ImageIO.read(Objects.requireNonNull(classLoader.getResource("blank.png")));
        } catch (IOException exception) {
            System.out.print("ERROR LOADING PIECE - TRAVIS PLEASE : " + exception);
            _image = null;
        }
        blankImage = _image;
    }

}