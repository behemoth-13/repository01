package com.javarush.test.level27.lesson15.big01.kitchen;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 21.07.2016.
 */
public class Waitor implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Cook cook = (Cook) o;
        Order order = (Order) arg;

    }
}