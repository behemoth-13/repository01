package com.javarush.test.level03.lesson12.home01;


import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 07.12.2015.
 */

public class TestException {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            names.add("gfhf");
        }
        for (String s : names) {
            s = "newnew";
        }
        for (String s : names) {
            System.out.println(s);
        }
    }
}