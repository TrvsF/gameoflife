package me.travis.gol.util;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Blank;
import me.travis.gol.object.Obj;
import me.travis.gol.object.person.Person;

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

    /**
     * converts gui coords to place on plane
     * @param n number to convert
     * @return the converted number
     */
    public static int coordsToPlane(int n) {
        return (n - 20) / 15;
    }

    public static int planeToCoords(int n) {
        return (n * 20) + 15;
    }

    /**
     * saves the current plane to a file
     * @param name Name of the file
     * @throws IOException E
     */
    public static void savePlaneToFile(String name) throws IOException {
        System.out.print("attempting to save file : " + name);
        // build string to be saved
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
        // write string via a buffered writer
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(System.getProperty("user.home") + "/Desktop/" + name + ".txt")));
        writer.write(sb.toString());
        writer.close();

        System.out.print("...DONE\n");
    }

    /**
     * load file from given path
     * @param path Path of file to load
     * @throws IOException E
     */
    public static void loadFile(String path) throws IOException {
        // Buffered Reader to read file
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        // add each line to a list of lines
        List<String[]> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line.split("\\s+"));
        }
        // create new plane and load file to it
        Obj[][] newPlane = new Obj[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            newPlane[i] = new Obj[lines.get(0).length];
            for (int j = 0; j < newPlane[i].length; j++) {
                newPlane[i][j] = (lines.get(i)[j].equals("P") ? new Person(1) : new Blank());
            }
        }
        // refresh plane
        GameOfLife.refreshPlane(newPlane);

        System.out.print("...DONE\n");
    }

}
