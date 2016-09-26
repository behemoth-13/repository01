package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStream inStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        while (inStream.available() > 0)
        {
            char data = (char) inStream.read();
            System.out.print(data);
        }
        inStream.close();
        //add your code here
    }
}
