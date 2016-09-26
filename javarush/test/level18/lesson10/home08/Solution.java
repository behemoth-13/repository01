package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources


public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args){
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}*/
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String s = reader.readLine();
        while (!s.equals("exit"))
        {
            ReadThread readThread = new ReadThread(s);
            readThread.start();
            readThread.join();
            s = reader.readLine();
        }
        inputStreamReader.close();
        reader.close();
    }

    public static class ReadThread extends Thread{
        private String path;

        public ReadThread(String fileName) throws IOException
        {
            path = fileName;//implement constructor body
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(path);
                HashMap<Integer, Integer> bytes = new HashMap<>();
                while (fileInputStream.available() > 0)
                {
                    int b = fileInputStream.read();
                    if (bytes.containsKey(b))
                    {
                        int value = bytes.get(b)+ 1;
                        bytes.put(b, value);
                    }
                    else
                    {
                        bytes.put(b, 1);
                    }
                }
                int max = 0;
                for (Map.Entry<Integer, Integer> entry : bytes.entrySet())
                {
                    int i = entry.getValue();
                    if (i > max)
                        max = i;
                }
                for (Map.Entry<Integer, Integer> entry : bytes.entrySet())
                {
                    int i = entry.getValue();
                    int b = entry.getKey();
                    if (i == max)
                    {
                            resultMap.put(path, b);
                    }
                }
                fileInputStream.close();
            }
            catch (FileNotFoundException e){}
            catch (IOException e){}
        }
    }
}
//for (Map.Entry<Integer, Integer> entry : bytes.entrySet())