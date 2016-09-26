package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
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
            }
        }
        i=0;
        for(Map.Entry entry: bytes.entrySet()) {
            Integer value =(Integer) entry.getValue();
            if (value > i)
                i = value;
        }
        for(Map.Entry entry: bytes.entrySet()) {
            Integer key =(Integer) entry.getKey();
            Integer value =(Integer) entry.getValue();
            if (value == i)
                System.out.print(key + " ");
        }
        fileInputStream.close();
    }
}