package com.javarush.test.level18.lesson10.bonus02;

import java.io.*;
import java.util.*;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


public class Solution {
    public static void main(String[] args) throws Exception {
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        if (args[0].equals("-c"))
        {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            int maxId = 0;
            String buffer = bufferedReader.readLine();
            while (buffer != null)
            {
                buffer = buffer.substring(0, 8);
                buffer = buffer.replaceAll(" ", "");
                int temp = Integer.parseInt(buffer);
                if (maxId < temp)
                {
                    maxId = temp;
                }
                buffer = bufferedReader.readLine();
            }
            bufferedReader.close();
            maxId++;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(maxId);
            for (int i = stringBuilder.length(); i < 8; i++)
            {
                stringBuilder.append(" ");
            }
            String productName = "";
            for (int i = 1; i < args.length-2; i++)
            {
                productName = productName.concat(args[i]);
                if (i < args.length-3)
                    productName = productName.concat(" ");
            }
            stringBuilder.append(productName);
            for (int i = stringBuilder.length(); i < 38; i++)
            {
                stringBuilder.append(" ");
            }
            stringBuilder.append(args[args.length-2]);
            for (int i = stringBuilder.length(); i < 46; i++)
            {
                stringBuilder.append(" ");
            }
            stringBuilder.append(args[args.length-1]);
            for (int i = stringBuilder.length(); i < 50; i++)
            {
                stringBuilder.append(" ");
            }
            System.out.println(stringBuilder.toString());
            FileWriter fileWriter  = new FileWriter(fileName);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        }
    }
}*/
public class Solution {
    public static void main(String[] args) throws Exception {
        try
        {
            if (!args[0].equals("-c"))throw new Exception();
            if (args[1].length()>30)throw new Exception();
            if (args[2].length()>8)throw new Exception();
            if (args[3].length()>4)throw new Exception();
        }catch (Exception e){
            System.out.println("Error");
        }
        String name = args[1];
        String price = args[2];
        String quantity = args[3];
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        try
        {
            if (args[0].equals("-c"))dbAdd(name,price,quantity,fileName);
            else throw new Exception();
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    public static void dbAdd(String productName,String price ,String quantity,String filename) throws Exception{
        //name 30 , price 8, quantity 4
        String result = "";
        char[] idArray = findID(filename);
        char[] charsArray = new char[50]; for (int i = 0; i <charsArray.length ; i++) { charsArray[i]=' '; }
        char[] productArray = productName.toCharArray();
        char[] priceArray = price.toCharArray();
        char[] quantityArray = quantity.toCharArray();
        System.arraycopy(idArray, 0, charsArray,0,idArray.length);
        System.arraycopy(productArray,0,charsArray,8,productArray.length);
        System.arraycopy(priceArray,0,charsArray,38,priceArray.length);
        System.arraycopy(quantityArray,0,charsArray,46,quantityArray.length);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
        result = new String(charsArray);
        writer.println(result);
        writer.close();
    }
    public static char[] findID(String filename) throws Exception{
        File file = new File(filename);
        if (file.length()==0)return new char[]{'0'};
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String data="";
        TreeSet<Integer> treeSet = new TreeSet<>();
        while ((data=br.readLine())!=null){
            try
            {
                String[] strings = data.substring(0,8).split(" ");
                treeSet.add(Integer.parseInt(strings[0].trim()));
            }catch (NumberFormatException r){
                r.printStackTrace();
                continue;
            }catch (StringIndexOutOfBoundsException e){
                continue;
            }
        }
        br.close();
        if (treeSet.isEmpty())return new char[]{'0'};
        int max = treeSet.last()+1;
        return String.valueOf(max).toCharArray();
    }
}