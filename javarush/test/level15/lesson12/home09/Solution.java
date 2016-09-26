package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String alert1 = "dfg";
        boolean ggg = false;
        ArrayList<String> list = new ArrayList<String>();
        char ch[] = s.toCharArray();
        for (int i = 0; i < ch.length; i++)
        {
            if (ch[i] == '?')
            {
                for (int f = i + 1; f < ch.length; )
                {
                    int d1 = f;

                    while (f < ch.length && ch[f] != '&')
                    {
                        f++;
                    }
                    int d2 = f;
                    int d3 = d2 - d1;
                    char ch2[] = new char[d3];
                    for (int i2 = 0; i2 < d3; i2++)
                    {
                        ch2[i2] = ch[d1];
                        d1++;
                    }
                    String temp = new String(ch2);
                    list.add(temp);
                    if (f < ch.length)
                    {
                        f++;
                    }
                }
            }
        }
        // list
        for (int i = 0; i < list.size(); i++)
        {
            String s2  = list.get(i);
            char chars[] = s2.toCharArray();
            if (s2.startsWith("obj="))
            {
                list.set(i,"obj");
                int i2 = 0;
                for (int i1 = 3; i1 < chars.length; i1++)
                {
                    if (chars[i1] == '=') //obj=3.14  i1=3, i2=4
                    {
                        i2 = i1 + 1;
                        break;
                    }
                }
                int i4 = chars.length - i2; // i4 = 4
                char ch2[] = new char[i4];
                for (int i3 = 0; i3 < i4; i3++)
                {
                    ch2[i3] = chars[i2];
                    i2++;
                }
                alert1 = new String(ch2);
                ggg = true;
            }// obj and alert
            else if(s2.contains("="))
            {
                int i2 = 0;
                for (int i1 = 0; i1 < chars.length; i1++) {
                    if (chars[i1] == '=') {
                        i2 = i1;// i2 = =
                        break;
                    }
                }
                char ch2[] = new char[i2];
                for (int i3 = 0; i3 < i2; i3++)
                {
                    ch2[i3] = chars[i3];
                }
                String temp2 = new String(ch2);
                list.set(i,temp2);
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
        if (ggg) {
            System.out.println();
            try {
                double d123 = Double.parseDouble(alert1);
                alert(d123);
            } catch (Exception e) {
                alert(alert1);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
