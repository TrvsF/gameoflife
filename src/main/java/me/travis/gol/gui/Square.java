package me.travis.gol.gui;

import me.travis.gol.GameOfLife;
import me.travis.gol.object.Blank;
import me.travis.gol.object.person.Person;
import me.travis.gol.util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * class containing the square object to be shown on screen
 */
public class Square extends JPanel implements MouseListener {

    private BufferedImage image;

    public Square(int x, int y, BufferedImage image) {
        this.setOpaque(false);
        this.image = image;
        this.setPos(x, y);
        this.addMouseListener(this);
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void updateImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * sets squares pos on screen
     * @param x X
     * @param y Y
     */
    private void setPos(int x, int y) {
        this.setBounds(x, y, 10, 10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (GameOfLife.ENGINE.isRunning()) return;
        if (GameOfLife.PLANE.getPlane()[Util.coordsToPlane(this.getY())][Util.coordsToPlane(this.getX())] instanceof Blank) {
            Person p = new Person(1);
            GameOfLife.PLANE.getPlane()[Util.coordsToPlane(this.getY())][Util.coordsToPlane(this.getX())] = p;
            this.updateImage(p.getImage());
        } else {
            Blank b = new Blank();
            GameOfLife.PLANE.getPlane()[Util.coordsToPlane(this.getY())][Util.coordsToPlane(this.getX())] = b;
            this.updateImage(b.getImage());
        }
        this.repaint();
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
