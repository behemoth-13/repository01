package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
         строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        BufferedReader br11 = new BufferedReader(new FileReader(name1));
        BufferedReader br22 = new BufferedReader(new FileReader(name2));
        while (br11.ready())
            list1.add(br11.readLine());
        while (br22.ready())
            list2.add(br22.readLine());
        if (list1.size() != list2.size())
        {
            if (list1.size() > list2.size())
            {
                int raz1 = list1.size() - list2.size();
                for (int i = list2.size(); i < list1.size(); i++)
                {
                    list2.add(i, "");
                }

            }
            else if (list2.size() > list1.size())
            {
                int raz1 = list2.size() - list1.size();
                for (int i = list1.size(); i < list2.size(); i++)
                {
                    list1.add(i, "");
                }

            }
        }
        for (int i = 0; i < list1.size(); i++)
        {
            if (list1.get(i).equals(list2.get(i))){}
            else if (list1.get(i).equals(list2.get(i + 1)))
            {
                list1.add(i, "");
                list2.add(list2.size(), "");
            }
            else if (list1.get(i + 1).equals(list2.get(i)))
            {
                list2.add(i, "");
                list1.add(list1.size(), "");
            }
        }
        for (int i = 0; i < list1.size(); i++)
        {
            if (list1.get(i).equals("") && list2.get(i).equals(""))
            {
                break;
            }
            else if (list1.get(i).equals(list2.get(i)))
            {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
            }
            else if (list1.get(i).equals(""))
            {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
            }
            else if (list2.get(i).equals(""))
            {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            }
            br.close();
            br11.close();
            br22.close();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
