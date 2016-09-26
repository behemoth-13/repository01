package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader((System.in)));
        String month = r.readLine();
        ArrayList<String> list = new ArrayList<>();
        list.add(0,"January");
        list.add(1,"February");
        list.add(2,"March");
        list.add(3,"April");
        list.add(4,"May");
        list.add(5,"June");
        list.add(6,"July");
        list.add(7,"August");
        list.add(8,"September");
        list.add(9,"October");
        list.add(10,"November");
        list.add(11,"December");
        for (int i = 0; i < 12; i++)
        {
            if (month.equals(list.get(i)))
            {
                int g = i + 1;
                System.out.println(month + " is " + g + " month");
            }
        }
        // /напишите тут ваш код
    }

}
