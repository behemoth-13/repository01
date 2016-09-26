package com.javarush.test.level18.lesson05.task04;

import java.io.*;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources


public class Solution {
    public static void main(String[] args) {

    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        byte[] buffer = new byte[inputStream.available()];
        int write = inputStream.read(buffer);
        for (int i = write - 1; i >= 0; i--)
            outputStream.write((int) buffer[i]);
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}