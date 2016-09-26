package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        StringBuilder sb = new StringBuilder("");
        while (br.ready())
        {
            sb = sb.append(br.readLine());
        }
        //...
        br.close();

        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder=new StringBuilder();
        if (words==null)
            return stringBuilder;
        if (words.length==0)
            return stringBuilder;
        if (words.length==1)
            return new StringBuilder(words[0]);

        ArrayList<String> arrayList = new ArrayList<String>();
        for (String word:words)
        {
            if (word!=null && !word.equals("") && !word.equals(" "))
                arrayList.add(word);
        }

        boolean check = true;
        while (check)
        {
            int r = 0;
            Collections.shuffle(arrayList);
            for (int i = 0; i < arrayList.size() - 1; i++)
            {
                if (arrayList.get(i).substring(arrayList.get(i).length() - 1, arrayList.get(i).length()).equalsIgnoreCase(arrayList.get(i + 1).substring(0, 1)))
                {
                    r++;
                }
            }
            if (r == arrayList.size() - 1)
                check = false;
        }
        String temp = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++)
        {
            temp += " " + arrayList.get(i);
        }
        return new StringBuilder(temp);
    }
}
