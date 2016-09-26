package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum;
        int  minimum;

        int[] mass = new int[20];
        for (int i = 0; i < 20; i++)
            mass[i] = Integer.parseInt(reader.readLine());
        maximum = mass[0];
        minimum = mass[0];
        for (int w = 0; w < 20; w++)
        {
            for (int i = 0; i < 20; i++)//max
                if (mass[i] > maximum)
                    maximum = mass[i];
        }
        for (int w = 0; w < 20; w++)
        {
            for (int i = 0; i < 20; i++)//max
                if (mass[i] < minimum)
                    minimum = mass[i];
        }
        //напишите тут ваш код


        System.out.println(maximum);
        System.out.println(minimum);
    }
}
