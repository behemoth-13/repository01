package com.javarush.test.level18.lesson10.home01;

import java.io.*;
import java.util.ArrayList;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources


public class Solution {
    public static void main(String[] args) {
    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream(args[0]);//читает строку посимвольно
        int count = 0;
        char c;
        ArrayList<Character> list = new ArrayList<Character>();
        while (fis.available() > 0)
        {
            c = (char) fis.read();
            list.add(c);
        }
        for (char ch : list)
        {
            if (ch > 64 && ch < 91 || ch > 96 && ch < 123)
                count++;
        }
        System.out.println(count);
        fis.close();
    }
}