package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        int count=0;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(rd.readLine());
        StringBuilder sb = new StringBuilder("");
        while (fr.ready()){
            sb.append((char) fr.read());
        }
        String[] array = sb.toString().split("[., '<>/\n\r!?;:-]");
        for (int i = 0; i < array.length; i++)
        {
            if (array[i].equals("world")) count++;
        }
        System.out.println(count);
        rd.close();
        fr.close();
    }
}