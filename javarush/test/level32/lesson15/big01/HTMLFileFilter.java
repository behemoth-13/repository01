package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Alex on 25.09.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File file)
    {
        if (file.isDirectory())
            return true;
        else{
            String fileName = file.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");
        }
    }
    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
