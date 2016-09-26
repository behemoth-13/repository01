package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int v = 0;
        for (boolean b = false; !b;)
        {
            String s = r.readLine();
            if (s.equals("сумма"))
                break;
            int a = Integer.parseInt(s);
            v = v + a;
        }
System.out.print(v);

        //напишите тут ваш код
    }


}
