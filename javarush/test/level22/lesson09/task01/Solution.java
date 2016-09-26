package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String sum = bufferedFileReader.readLine();
        while (bufferedFileReader.ready())
            sum += " " + bufferedFileReader.readLine();
        String[] strs = sum.split(" ");
        for (int i= 0; i < strs.length; i++)
        {
            if (strs[i] != null)
            {
                String s = new StringBuilder(strs[i]).reverse().toString();
                for (int i1 = i+1; i1 < strs.length; i1++)
                {
                    if (s.equals(strs[i1]) && strs[i1]!=null && strs[i]!=null)
                    {
                        Pair p = new Pair();
                        p.first = strs[i];
                        p.second = strs[i1];
                        result.add(p);
                        for (int i2 = i1; i2 < strs.length; i2++)
                        {
                            if (s.equals(strs[i2]) || strs[i].equals(strs[i2]))
                                strs[i2] = null;
                        }
                        strs[i] = null;
                    }
                }
            }
        }
        for (Pair pair : result)
            System.out.println(pair.first + " " + pair.second);
        bufferedFileReader.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}
//86