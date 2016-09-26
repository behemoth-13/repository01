package com.javarush.test.level18.lesson10.home07;

import java.io.*;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке


public class Solution {
    public static void main(String[] args) {
    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String path = reader.readLine();
        FileReader fileReader = new FileReader(path);
        BufferedReader reader1 = new BufferedReader(fileReader);
        while (reader1.ready())
        {
            String[] str = reader1.readLine().split(" ");
            if (args[0].equals(str[0]))
            {
                int id = Integer.parseInt(str[0]);
                String name = "";
                for (int i1 = 1; i1 < str.length - 2; i1++)
                {
                    name = name + " " + str[i1];
                }
                double d = Double.parseDouble(str[str.length - 2]);
                int quantity = Integer.parseInt(str[str.length - 1]);
                System.out.print(id + name + " " + d + " " + quantity);
                System.out.println();
            }
        }
        fileReader.close();
        reader1.close();
        inputStreamReader.close();
        reader.close();
    }
}