package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> treeMap = new TreeMap<String, Double>();
        String temp = bufferedReader.readLine();
        while(temp != null)
        {
            String[] massiv = temp.split(" ");
            if (treeMap.containsKey(massiv[0]))
            {

                treeMap.put(massiv[0], treeMap.get(massiv[0]) + Double.parseDouble(massiv[1]));
            }
            else
            {
                treeMap.put(massiv[0], Double.parseDouble(massiv[1]));
            }
            temp = bufferedReader.readLine();
        }
        bufferedReader.close();
        double max = 0;
        for (Map.Entry<String, Double> entry : treeMap.entrySet())
        {
            if (entry.getValue() > max)
            {
                max = entry.getValue();
            }
        }
        for (Map.Entry<String, Double> entry : treeMap.entrySet())
        {
            if (entry.getValue().equals(max))
            {
                System.out.println(entry.getKey());
            }
        }
    }
}
