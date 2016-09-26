package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода


public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int temp = fileInputStream.read();
        int min = temp;
        while (fileInputStream.available() > 0)
        {
            temp = fileInputStream.read();
            if (temp < min)
            {
                min = temp;
            }
        }
        System.out.println(min);
        fileInputStream.close();
    }
}