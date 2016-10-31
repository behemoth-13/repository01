package com.javarush.test.level03.lesson12.home01;


import javax.xml.bind.JAXBException;
import java.text.DecimalFormat;

/**
 * Created by Alex on 07.12.2015.
 */

public class TestException {
    public static void main(String[] args) {
        String value = "tan(45)";

        System.out.println(value.substring(4, 5));
    }
}