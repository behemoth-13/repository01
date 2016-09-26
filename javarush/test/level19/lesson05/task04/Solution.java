package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file1 = read.readLine();
        String file2 = read.readLine();
        read.close();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        while (fileInputStream.available() > 0)
        {
            char temp = (char) fileInputStream.read();
            if (temp == '.')
                fileOutputStream.write((int) '!');
            else fileOutputStream.write((int) temp);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
