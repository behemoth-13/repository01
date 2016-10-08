package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Alex on 06.10.2016.
 */
public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.orange);
        graphics.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2, this.getWidth(), this.getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
