package com.javarush.test.level18.lesson10.bonus03;

import java.io.*;
import java.util.*;
/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = null;
        try
        {
            path = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException e){System.out.println("хз");}
        if (args.length > 1)
        switch (args[0]){
            case "-u" :
            {
                update(path, args);
                break;
            }
            case "-d" :
            {
                delete(path, args);
                break;
            }
        }
    }

    public static void update(String path, String[] args){
        String StringToFile = stringForUpdate(args);
        String id = args[1];
        ArrayList<String> listToFile = new ArrayList<String>();
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String temp = bufferedReader.readLine();
            while(temp != null)
            {
                String idFromFile = temp.substring(0, 8).trim();
                if (id.equals(idFromFile))
                {
                    listToFile.add(StringToFile);
                }
                else listToFile.add(temp);
                temp = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException e){System.out.println("файла нет");}
        catch (IOException e){System.out.println("хз");}
        writeFile(listToFile, path);
    }

    public static String stringForUpdate(String[] args) throws ArrayIndexOutOfBoundsException{
        String id = args[1];
        String productName = args[2];
        for (int i = 3; i < args.length - 2; i++)
        {
            if (i == args.length - 3)
            productName = productName.concat(args[i]);
            else productName = productName.concat(args[i]).concat(" ");
        }
        String price = args[args.length - 2];
        String quantity = args[args.length - 1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id);
        for (int i = stringBuilder.length(); i < 8; i++)
        {
            stringBuilder.append(" ");
        }
        stringBuilder.append(productName);
        for (int i = stringBuilder.length(); i < 38; i++)
        {
            stringBuilder.append(" ");
        }
        stringBuilder.append(price);
        for (int i = stringBuilder.length(); i < 46; i++)
        {
            stringBuilder.append(" ");
        }
        stringBuilder.append(quantity);
        for (int i = stringBuilder.length(); i < 50; i++)
        {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void delete(String path, String[] args){
        String id = args[1];
        ArrayList<String> listToFile = new ArrayList<String>();
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String temp = bufferedReader.readLine();
            while(temp != null)
            {
                String idFromFile = temp.substring(0, 8).trim();
                if (!id.equals(idFromFile))
                {
                    listToFile.add(temp);
                }
                temp = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException e){System.out.println("файла нет");}
        catch (IOException e){System.out.println("хз");}
        writeFile(listToFile, path);
    }

    public static void writeFile(ArrayList<String> listToFile, String path)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String i : listToFile)
            {
                writer.write(i);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e){System.out.println("хз");}
    }
}
