package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by Alex on 06.10.2016.
 */
public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int xThis = this.getX();
        int yThis = this.getY();
        int xOb = gameObject.getX();
        int yOb = gameObject.getY();
        int field = Model.FIELD_SELL_SIZE;
        switch (direction) {
            case LEFT:
                return xThis - field == xOb && yThis == yOb;
            case RIGHT:
                return xThis + field == xOb && yThis == yOb;
            case UP:
                return xThis == xOb && yThis - field == yOb;
            case DOWN:
                return xThis == xOb && yThis + field == yOb;
        }
        return true;
    }
}

