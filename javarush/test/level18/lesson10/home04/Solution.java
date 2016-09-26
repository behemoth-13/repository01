package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources

public class Solution {
    public static void main(String[] args)
    {

    }
}*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();//"h:\\1.txt";//
        String path2 = reader.readLine();//"h:\\2.txt";//
        reader.close();
        FileInputStream f1 = new FileInputStream(path1);
        byte[] b1read = new byte[f1.available()];
        f1.read(b1read);
        f1.close();
        f1 = new FileInputStream(path2);
        byte[] b2read = new byte[f1.available()];
        f1.read(b2read);
        f1.close();
        FileOutputStream f2 = new FileOutputStream(path1);
        for (byte b : b2read)
            f2.write(b);
        for (byte b : b1read)
            f2.write(b);
        f2.close();
    }
}
