package com.javarush.test.level18.lesson10.home03;

import java.io.*;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources

public class Solution {
    public static void main(String[] args) throws IOException
    {

    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream first = new FileOutputStream(reader.readLine());
        FileInputStream second = new FileInputStream(reader.readLine());
        FileInputStream third = new FileInputStream(reader.readLine());
        while (second.available() > 0)
            first.write(second.read());
        while (third.available() > 0)
            first.write(third.read());
        reader.close();
        first.close();
        second.close();
        third.close();
    }
}
