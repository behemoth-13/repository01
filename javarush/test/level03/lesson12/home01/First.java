package com.javarush.test.level03.lesson12.home01;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Alex on 09.10.2016.
 */

@XmlType(name = "first")
@XmlRootElement

public class First {
    public String name;
    public int age;
    public int weight;

    First() {
    }
}

