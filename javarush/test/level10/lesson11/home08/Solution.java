package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] ar = new ArrayList[3];
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("ar");
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("ar2");
        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("ar3");
        ar[0] = a1;
        ar[1] = a2;
        ar[2] = a3;
        //напишите тут ваш код

        return ar;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}