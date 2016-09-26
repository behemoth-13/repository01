package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода


public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int max = 0;
        int temp;
        while (fileInputStream.available() > 0)
        {
            temp = fileInputStream.read();
            if (temp > max)
            {
                max = temp;
            }
        }
        System.out.println(max);
        fileInputStream.close();
    }
}