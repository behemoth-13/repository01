package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Alex on 18.10.2016.
 */
public class FactoryException {
    public static Throwable getException(Enum enumeration) {

        if (enumeration != null) {
            if (enumeration instanceof ExceptionApplicationMessage) {
                return new Exception(enumeration.name().charAt(0) + enumeration.name().substring(1).toLowerCase().replace("_", " "));
            } else if (enumeration instanceof ExceptionDBMessage) {
                return new RuntimeException(enumeration.name().charAt(0) + enumeration.name().substring(1).toLowerCase().replace("_", " "));
            } else if (enumeration instanceof ExceptionUserMessage) {
                return new Error(enumeration.name().charAt(0) + enumeration.name().substring(1).toLowerCase().replace("_", " "));
            }
        }
        return new IllegalArgumentException();
    }
}