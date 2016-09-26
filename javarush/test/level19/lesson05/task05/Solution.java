package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(read.readLine());
        FileWriter fwr = new FileWriter(read.readLine());
        read.close();
        String s ="";
        while (fr.ready()){
            char tmp = (char) fr.read();
            s += tmp;
        }
        s = s.replaceAll("\\p{Punct}", "");
        fwr.write(s);
        fr.close();
        fwr.close();
    }
}
