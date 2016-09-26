package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStream in = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        Scanner sc = new Scanner(in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (in.available()>0)
        {
            while(sc.hasNextInt())
            {
                int data = sc.nextInt();
                list.add(data);
            }
        }
        for (int i = 0; i<list.size();)
        {
            if (list.get(i)%2 != 0) list.remove(i);
            else i++;
        }

        for (int i = list.size()-1; i>=0; i--)
        {
            for (int j = 0; j<i; j++)
            {
                if (list.get(j)>list.get(j+1))
                {
                    Integer temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        for (int i =0; i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        // напишите тут ваш код
    }
}
