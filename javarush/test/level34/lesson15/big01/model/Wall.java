package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Alex on 07.10.2016.
 */
public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2, this.getWidth(), this.getHeight());
    }
}
