package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception
    {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        Date d = new Date(s);
        format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        s = format.format(d);
        String f = s.toUpperCase();
        System.out.println(f);
        //напишите тут ваш код
    }
}
