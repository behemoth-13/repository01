package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Alex on 30.03.2016.
 */
public class Plane implements Flyable
{
    int pass;
    Plane(int pass)
    {
        this.pass = pass;
    }
    @Override
    public void fly()
    {
    }
}
