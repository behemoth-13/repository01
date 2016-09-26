package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList list = new ArrayList();
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        int n = N;
        for (; n > 0; n--)
            list.add(reader.readLine());
        int m = N;
        int i = 0;
        n = M;
        for (; n > 0; n--)
        {
            list.add(m, list.get(i));
            i++;
            m++;
        }
        m = M - 1;
        for (; m >= 0; m--)
            list.remove(m);
        for (i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        //напишите тут ваш код
    }
}
