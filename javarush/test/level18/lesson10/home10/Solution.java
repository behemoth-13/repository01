package com.javarush.test.level18.lesson10.home10;

import java.io.*;
import java.util.*;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources


public class Solution {
    public static void main(String[] args) {
    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> parts = new TreeSet<String>();
        String s = bufferedReader.readLine();
        String path = s;
        while(!s.equals("end"))
        {
            parts.add(s);
            s = bufferedReader.readLine();
        }
        s = path.substring(0, path.lastIndexOf("."));
        FileOutputStream fileOutputStream = new FileOutputStream(s);

        for (String str : parts)
        {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        bufferedReader.close();
        fileOutputStream.close();
    }
}