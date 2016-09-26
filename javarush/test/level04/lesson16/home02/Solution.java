package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(r.readLine());
        int a2 = Integer.parseInt(r.readLine());
        int a3 = Integer.parseInt(r.readLine());
        if ( a2 < a1 && a1 < a3)
            System.out.print(a1);
        if ( a3 < a1 && a1 < a2)
            System.out.print(a1);
        if ( a1 < a2 && a2 < a3)
            System.out.print(a2);
        if ( a3 < a2 && a2 < a1)
            System.out.print(a2);
        if ( a2 < a3 && a3 < a1)
            System.out.print(a3);
        if ( a1 < a3 && a3 < a2)
            System.out.print(a3);
        //напишите тут ваш код
    }
}
