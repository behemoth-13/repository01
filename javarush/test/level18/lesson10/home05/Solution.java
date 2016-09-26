package com.javarush.test.level18.lesson10.home05;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4


public class Solution {
    public static void main(String[] args) {

    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        Scanner scanner = new Scanner(new FileReader(path1)).useLocale(Locale.ENGLISH);
        FileWriter writer1 = new FileWriter(path2);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextDouble())
        {
            double d = scanner.nextDouble();
            int i = (int) Math.round(d);
            sb.append(i + " ");
        }
        writer1.write(sb.toString());
        reader.close();
        scanner.close();
        writer1.close();
    }
}