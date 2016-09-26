package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
+3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(s1));
        String temp = reader.readLine();
        while (temp != null) {
            allLines.add(temp);
            temp = reader.readLine();
        }
        reader.close();
        reader = new BufferedReader(new FileReader(s2));
        temp = reader.readLine();
        while (temp != null) {
            forRemoveLines.add(temp);
            temp = reader.readLine();
        }
        reader.close();
        }
        catch (IOException e){}
        Solution solution = new Solution();
        try
        {
            solution.joinData();
        }
        catch(CorruptedDataException e)
        {

        }
        /*for (String ss : allLines)
            System.out.println(ss);
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDD");
        for (String ss : forRemoveLines)
            System.out.println(ss);*/
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        } else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
        /*if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        }
        else {
            boolean b = true;
            for (String s : forRemoveLines)
                if (allLines.contains(s))
                {
                    b = false;
                }
            if (b){
                allLines.clear();
                throw new CorruptedDataException();
            }

        }*/
    }
}
