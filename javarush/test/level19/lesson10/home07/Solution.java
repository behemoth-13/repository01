package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        String name1 = args[0];
        String name2 = args[1];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name2));
        ArrayList<String> list = new ArrayList<>();
        while (bufferedReader.ready())
        {
            String[] strings = bufferedReader.readLine().split(" ");
            for (String s : strings)
            {
                if (s.length() > 6)
                    list.add(s);
            }
        }
        if (list.size() > 0)
        bufferedWriter.write(list.get(0));
        for (int i = 1; i < list.size(); i++)
        {
            bufferedWriter.write("," + list.get(i));
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
