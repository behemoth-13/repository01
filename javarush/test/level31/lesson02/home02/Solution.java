package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File(root));
        for (int i = 0; i < files.size();i++)
        {
            File file = files.get(i);
            if (file.isDirectory())
            {
                File[] filesTemp1 = file.listFiles();
                if (filesTemp1 != null)
                {
                    Collections.addAll(files, filesTemp1);
                }
                files.remove(file);
                i--;
            }
        }
        for (File file : files)
        {
            result.add(file.getAbsolutePath());
        }
        return result;
    }
}
