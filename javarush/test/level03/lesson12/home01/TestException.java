package com.javarush.test.level03.lesson12.home01;


import javax.xml.bind.JAXBException;

/**
 * Created by Alex on 07.12.2015.
 */

public class TestException {
    public static void main(String[] args) {
        First cat = new First();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        try {
            System.out.println(com.javarush.test.level33.lesson10.bonus01.Solution.toXmlWithComment(cat, "dfgdf", "bhvcb"));
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}