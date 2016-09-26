package com.javarush.test.level18.lesson05.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','


public class Solution {
    public static void main(String[] args) {
    }

}*/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int count = 0;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if ((char) data == 44)
                count++;
        }
        System.out.println(count);
        reader.close();
        inputStream.close();
    }
}
