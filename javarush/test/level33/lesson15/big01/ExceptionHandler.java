package com.javarush.test.level33.lesson15.big01;

/**
 * Created by Alex on 29.09.2016.
 */
public class ExceptionHandler
{
    public static void log(Exception e){
        Helper.printMessage(e.getMessage());
    }
}
