package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String name1 = bufferedReader.readLine();
            String name2 = bufferedReader.readLine();
            FileInputStream fileReader = new FileInputStream(name1);
            FileOutputStream fileWriter = new FileOutputStream(name2);
            bufferedReader.close();
            int count = 0;
            while (fileReader.available() > 0)
            {
                count++;
                int data = fileReader.read();
                if (count % 2 == 0) {
                    fileWriter.write(data);
                }
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
