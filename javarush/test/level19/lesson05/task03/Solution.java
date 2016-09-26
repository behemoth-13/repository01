package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file1 = read.readLine();
        String file2 = read.readLine();
        read.close();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileR = new BufferedWriter(new FileWriter(file2, true));
        while (reader.ready())
        {
            String[] ff = reader.readLine().split("\\s+");
            for (String x : ff)
            {
                if (x.matches("([-]?[\\d]+)?([\\d]+[.]?[\\d]+)?"))
                {
                    fileR.write(x + " ");
                    System.out.println(x);
                }
            }
        }
        reader.close();
        fileR.close();
    }
}