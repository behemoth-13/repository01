package com.javarush.test.level32.lesson02.task01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) {
        try
        {
            String fileName = args[0];
            int number = Integer.parseInt(args[1]);
            String text = args[2];
            try(RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")){
                if (randomAccessFile.length() > number){
                    randomAccessFile.seek(number);
                    randomAccessFile.write(text.getBytes());
                }
                else {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(text.getBytes());
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
