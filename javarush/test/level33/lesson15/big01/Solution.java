package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 29.09.2016.
 */
public class Solution {
    public static void main(String[] args) {
        //testStrategy(new HashMapStorageStrategy(), 10000);
        //testStrategy(new OurHashMapStorageStrategy(), 10000);
        //testStrategy(new FileStorageStrategy(), 1);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> longs = new HashSet<>();
        for (String s : strings) {
            longs.add(shortener.getId(s));
        }
        return longs;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long l : keys) {
            strings.add(shortener.getString(l));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings1 = new HashSet<>();
        for (long l = 0; l < elementsNumber; l++) {
            strings1.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date start = new Date();
        Set<Long> longs = getIds(shortener, strings1);
        Helper.printMessage("Время на getIds: " + String.valueOf(new Date().getTime() - start.getTime()));
        start = new Date();
        Set<String> strings2 = getStrings(shortener, longs);
        Helper.printMessage("Время на getStrings: " + String.valueOf(new Date().getTime() - start.getTime()));
        if (strings1.equals(strings2))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
