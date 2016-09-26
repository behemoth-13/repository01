package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int b = 0;
        for (int a = 0, c = 0;true ;b = b + a )
        {
            if (a == -1)
                break;
            a = Integer.parseInt(r.readLine());
        }
        System.out.print(b);//напишите тут ваш код
    }
}
