package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/


import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String way = r.readLine();
        ArrayList<String> list = new ArrayList<String>();
        String s = r.readLine();
        while(!s.equals("exit"))
        {
            list.add(s);
            s = r.readLine();
        }
        list.add("exit");
        OutputStream outStream = new FileOutputStream(way);
        byte[] lineSeparator = System.lineSeparator().getBytes();
        for (String d : list)
        {
            byte[] v = d.getBytes();
            outStream.write(v);
            outStream.write(lineSeparator);
        }
        outStream.close();
    }
}
