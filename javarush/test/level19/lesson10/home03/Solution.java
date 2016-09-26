package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String temp = bufferedReader.readLine();
        while (temp != null)
        {
            String[] in = temp.split(" ");
            String name = in[0];
            for (int i = 1; i < in.length - 3; i++)
            {
                name = name.concat(" " + in[i]);
            }
            int day = Integer.parseInt(in[in.length - 3]);
            int month = Integer.parseInt(in[in.length - 2]);
            int year = Integer.parseInt(in[in.length - 1]);
            Date birthday = new Date(year, month - 1, day);
            Person person = new Person(name, birthday);
            PEOPLE.add(person);
            temp = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

}
