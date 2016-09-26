package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());
        int q,w,r,t,y;

        if (a>b) q = b;//q min
        else q = a;
        if (q>c) q = c;
        if (q>d) q = d;
        if (q>e) q = e;

        w=q+a+b+c+d+e;
        if (w>a && a!=q) w = a;//www
        if (w>b && b!=q) w = b;
        if (w>c && c!=q) w = c;
        if (w>d && d!=q) w = d;
        if (w>e && e!=q) w = e;

        if (a<b) y = b;//y max
        else y = a;
        if (y<c) y = c;
        if (y<d) y = d;
        if (y<e) y = e;

        t=q;
        if (t<a && a!=y) t = a;
        if (t<b && b!=y) t = b;
        if (t<c && c!=y) t = c;
        if (t<d && d!=y) t = d;
        if (t<e && e!=y) t = e;

        r=a;
        if (w<a && a<t) r=a;
        if (w<b && b<t) r=b;
        if (w<c && c<t) r=c;
        if (w<d && d<t) r=d;
        if (w<e && e<t) r=e;

        System.out.println(q);
        System.out.println(w);
        System.out.println(r);
        System.out.println(t);
        System.out.println(y);
        //напишите тут ваш код
    }
}
