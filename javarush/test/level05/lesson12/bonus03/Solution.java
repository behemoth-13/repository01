package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        for (int i = 0; i < 1; i++)
        {
            int c = Integer.parseInt(reader.readLine());
            if (c > 0)
            N = c - 1;
            else
            i--;
        }
        int b = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++)
        {
            int a = Integer.parseInt(reader.readLine());
            if (a > b)
                b = a;
        }
        System.out.println(b);
    }
}
