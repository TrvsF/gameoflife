package me.travis.gol.util;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.person.Person;
import me.travis.gol.plane.Plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * basic util
 */
public class Util {

    private final static Random random = new Random();

    /**
     * returns a random int between 2 values
     * @param min Min value
     * @param max Max value
     * @return random int
     */
    public static int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * random index of a given list
     * @param l given list
     * @return random index (returns 0 if list is null)
     */
    public static int getRandomListIndex(List l) {
        if (l == null) return 0;
        return random.nextInt(l.size());
    }

    /**
     * converts tps to ms
     * @param tps Tps
     * @return ms
     */
    public static double tpsToMs(double tps) {
        return (1/tps) * 1000;
    }

    public static boolean isBlank(BufferedImage image) throws IOException {
        return image == ImageIO.read(new File("src/main/resources/blank.png"));
    }

    public static int coordsToPlane(int n) {
        return (n - 40) / 40;
    }

    public static int planeToCoords(int n) {
        return (n * 40) + 40;
    }

    public static void savePlaneToFile(String name) throws IOException {
        System.out.println("attempting to save file : " + name);
        StringBuilder sb = new StringBuilder();
        for (Obj[] objs : GameOfLife.PLANE.getPlane()) {
            for (int j = 0; j < objs.length; j++) {
                sb.append(objs[j].getId());
                if (j < objs.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(System.getProperty("user.home") + "/Desktop/" + name + ".txt")));
        writer.write(sb.toString());
        writer.close();
        System.out.println("DONE");
    }

    public static void loadFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        List<String[]> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line.split("\\s+"));
        }

        Obj[][] newPlane = new Obj[lines.size()][];

        for (int i = 0; i < lines.size(); i++) {
            newPlane[i] = new Obj[lines.get(0).length];
            for (int j = 0; j < newPlane[i].length; j++) {
                newPlane[i][j] = (lines.get(i)[j].equals("P") ? new Person(1) : new Blank());
            }
        }

        GameOfLife.refreshPlane(newPlane);
    }

}
