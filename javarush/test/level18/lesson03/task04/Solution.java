package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода


public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        HashMap<Integer, Integer> bytes = new HashMap<Integer, Integer>();
        int i;
        int i2 = 1;
        while (fileInputStream.available() > 0)
        {
            i = fileInputStream.read();
            if (!bytes.containsKey(i))
            {
                bytes.put(i, 1);
            }
            else if (bytes.containsKey(i))
            {
                bytes.put(i, bytes.get(i) + 1);
                if (bytes.get(i) + 1 > i2)
                    i2 = bytes.get(i) + 1;
            }
        }
        i2++;
        for(Map.Entry entry: bytes.entrySet()) {
            Integer value =(Integer) entry.getValue();
            if (value < i2)
                i2 = value;
        }
        for(Map.Entry entry: bytes.entrySet()) {
            Integer key =(Integer) entry.getKey();
            Integer value =(Integer) entry.getValue();
            if (value == i2)
                System.out.print(key + " ");
        }
        fileInputStream.close();
    }
}