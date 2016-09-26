package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83


public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
Программа успешно прошла тестирование.
Вы решили задачу лучше, чем 98% учеников.
Вам удалось решить ее с 1 попытки.
Среднее к-во попыток для этой задачи - 3.5337.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList<Integer> array = new ArrayList<Integer>();
        int i;
        while (fileInputStream.available() > 0)
        {
            i = fileInputStream.read();
            if (!array.contains(i))
                array.add(i);
        }
        Collections.sort(array);
        for (i = 0; i < array.size(); i++)
            System.out.print(array.get(i) + " ");
        fileInputStream.close();
    }
}
