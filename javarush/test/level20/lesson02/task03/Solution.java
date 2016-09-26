package com.javarush.test.level20.lesson02.task03;


import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
            FileInputStream inputStream = new FileInputStream(fileName);
            scanner.close();
            load(inputStream);
            inputStream.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            prop.setProperty(pair.getKey(), pair.getValue());
        }
        PrintWriter writer = new PrintWriter(outputStream);
        prop.store(writer, "");
        writer.close();
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        Set<String> list = prop.stringPropertyNames();
        for (String s : list)
        {
            properties.put(s, prop.getProperty(s));
        }
        //implement this method - реализуйте этот метод
    }
}
