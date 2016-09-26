package com.javarush.test.level18.lesson10.home09;

import java.io.*;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();


public class Solution {
    public static void main(String[] args) {
    }
}*/
public class Solution {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = null;
        FileInputStream fileReader = null;
        try
        {
            do
            {
                s = bufferedReader.readLine();
                fileReader = new FileInputStream(s);
            }
            while (true);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(s);
        }
        catch (IOException e){}
        try
        {
            inputStreamReader.close();
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e){}
    }
}