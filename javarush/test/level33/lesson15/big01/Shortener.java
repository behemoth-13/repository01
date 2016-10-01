package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by Alex on 29.09.2016.
 */
public class Shortener
{
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy)
    {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){
        if (storageStrategy.containsValue(string)){
            return storageStrategy.getKey(string);
        }
        else{
            storageStrategy.put(++lastId, string);
            return lastId;
        }
    } //будет возвращать идентификатор id для заданной строки.

    public synchronized String getString(Long id){
        if (storageStrategy.containsKey(id)){
            return storageStrategy.getValue(id);
        }
        return null;
    }//будет возвращать строку для заданного идентификатора или null, если передан неверный идентификатор.
}
