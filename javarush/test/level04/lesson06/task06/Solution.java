package com.javarush.test.level04.lesson06.task06;

/* И 18-ти достаточно
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader t =  new BufferedReader(new InputStreamReader(System.in));
        String c = t.readLine();
        String a = t.readLine();
        int b = Integer.parseInt(a);
        if (b > 20)
            System.out.print("И 18-ти достаточно");//напишите тут ваш код

    }
}
