package com.javarush.test.level03.lesson12.home01;


import java.util.ArrayList;

/**
 * Created by Alex on 07.12.2015.
 */

public class TestException {
    public static void main(String[] args)
    {
        String name = "name";
        long size = 512* 1024;
        long compressedSize = 288* 1024;

       System.out.println(String.format("%s %d Kb (%d Kb) сжатие: %d%%", name , size/1024, compressedSize/1024, compressedSize));
    }
}