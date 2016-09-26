package com.javarush.test.level19.lesson10.home05;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources


public class Solution {
    public static void main(String[] args) {
    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        String name1 = args[0];
        String name2 = args[1];
        BufferedReader br = new BufferedReader(new FileReader(name1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(name2));
        while (br.ready())
        {
            String readedString = br.readLine();
            String[] readedWords = readedString.split(" ");
            for (String s : readedWords)
            {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(s);
                if (matcher.find())
                {
                    bw.write(s + " ");
                }
            }
        }
        br.close();
        bw.close();
    }
}