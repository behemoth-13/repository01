package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(gcd(Integer.parseInt(r.readLine()), Integer.parseInt(r.readLine())));
    }
        public static int gcd(int a, int b)
        {
        while (b != 0)
        {
            int x = a % b;
            a = b;
            b = x;
        }
            return a;
    }
}
