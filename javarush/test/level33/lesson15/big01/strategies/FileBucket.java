package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Created by Alex on 30.09.2016.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmp", null);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        /*long l = 0;
        try
        {
            l = Files.size(path);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }*/
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oOut.writeObject(entry);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        Entry entry = null;
        if (getFileSize() == 0)
            return null;
        try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            entry = (Entry) oIn.readObject();
        }
        catch (ClassNotFoundException | IOException e) {
            ExceptionHandler.log(e);
        }
        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
