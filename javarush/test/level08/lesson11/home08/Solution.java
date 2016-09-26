package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);

    }

    public static void sort(int[] array)
    {

        int[] array2 = new int[20];
        int min = array[0];
        for (int o = 0; o < array.length; o++)
        {
            if (array[o] < min)
                min = array[o];
        }
        for (int p =0; p < array.length; p++ )
        {
            int max = min;
            for (int s =0; s < array.length; s++ )//max
            {
                if (array[s] == max)
                {
                    max = array[s];
                }
            }
            for (int s =0; s < array.length; s++)
            {
                if (array[s] > max)
                {
                    max = array[s];
                }
            }//max
            array2[p] = max;
            for (int s =0; s < array.length; s++ )
            {
                if (array[s] == max)
                {
                    int min1 = min -1;
                    array[s] = min1;
                    break;
                }//напишите тут ваш код
            }

        }
        for (int o = 0; o < array.length; o++)
        {
            array[o] = array2[o];
        }

    }
}
