package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            numbers.add(i,1);
        }
        for (int i = 0; i < list.size(); i++)
        {
            for (int a = 0; a < list.size(); a++)
            {
                if (list.get(i).equals(list.get(a)))
                {
                    if(i != a)
                    {
                        numbers.set(i, numbers.get(i) + 1);
                        list.remove(a);
                        a--;
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            result.put(list.get(i), numbers.get(i));
        }
        return result;
    }

}
