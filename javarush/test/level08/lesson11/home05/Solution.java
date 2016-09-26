package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stroka = reader.readLine();
        char[] letters = stroka.toCharArray();
        //сделали массив из букв
        String s3 = Character.toString(letters[0]);
        if (!s3.equals(" "))
            letters[0] = Character.toUpperCase(letters[0]);
        for (int j = 0; j < letters.length - 1; j++)
        {
            String s = Character.toString(letters[j]);
            String s1 = Character.toString(letters[j+1]);
            if (s.equals(" ") && !s1.equals(" "))
            {
                letters[j+1] = Character.toUpperCase(letters[j+1]); // сделали первую букву большой
            }
        }
        for (int j = 0; j < letters.length; j++)
        System.out.print(letters[j]);
        //напишите тут ваш код
    }
}
