package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
public class Solution {
    public static void main(String[] args) {
    }
}*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        int length = inputStream.available();
            while (inputStream.available() > length/2)
            {
                int i = inputStream.read();
                outputStream.write(i);
            }
            while (inputStream.available() > 0)
            {
                int i = inputStream.read();
                outputStream2.write(i);
            }
        reader.close();
        inputStream.close();
        outputStream.close();
        outputStream2.close();
    }
}
