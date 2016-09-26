package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А A Б Д  //2 слова - подходит, выводим


public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

    }
}
*/
public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(nameFile));
        String s = bufferedReader1.readLine();
        while (s != null)
        {
            int coincidence = 0;
            for (String word : words)
            {
                String[] strings = s.split(" ");
                for (String s1 : strings)
                {
                    if (word.equals(s1))
                    {
                        coincidence++;
                        break;
                    }
                }

            }
            if (coincidence == 2)
            {
                System.out.println(s);
            }
            s = bufferedReader1.readLine();
        }
        bufferedReader1.close();
    }
}