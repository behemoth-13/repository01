package com.javarush.test.level18.lesson10.home06;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361


public class Solution {
    public static void main(String[] args) {

    }
}
public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream f1 = new FileInputStream(args[0]);
        byte[] by = new byte[f1.available()];
        while (f1.available() > 0)
        {
            f1.read(by);
        }
        Arrays.sort(by);
        for (int i = 0; i < by.length; i++)
        {
            int i1 = 1;
            byte b1 = by[i];
            if (i == by.length - 1)
            {
                System.out.println((char)b1 + " " + i1);
                break;
            }
            else
            {
                while (b1 == by[i + 1])
                {
                    i1++;
                    if (i < by.length)
                    {
                        i++;
                    } else
                    {
                        break;
                    }
                }
            }
             System.out.println((char)b1 + " " + i1);
        }
        f1.close();
    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        Map<Integer, Integer> characterIntegerMap = new TreeMap<>();
        while(fileInputStream.available() > 0){
            int currentANSI = fileInputStream.read();
            if(characterIntegerMap.containsKey(currentANSI)){
                characterIntegerMap.put(currentANSI, characterIntegerMap.get(currentANSI) + 1);
            }else{
                characterIntegerMap.put(currentANSI, 1);
            }
        }
        for (Map.Entry<Integer, Integer> pair : characterIntegerMap.entrySet()){
            int key = pair.getKey();
            int value = pair.getValue();
            System.out.println((char)key + " " + value);
        }
        fileInputStream.close();
    }
}