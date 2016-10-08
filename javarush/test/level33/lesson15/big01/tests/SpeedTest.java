package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 02.10.2016.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date start = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return new Date().getTime() - start.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date start = new Date();
        for (long l : ids) {
            strings.add(shortener.getString(l));
        }
        return new Date().getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        long time1 = getTimeForGettingIds(shortener1, origStrings, ids);
        ids.clear();
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids);
        origStrings.clear();
        Assert.assertTrue(time1 > time2);
        long time3 = getTimeForGettingStrings(shortener1, ids, origStrings);
        origStrings.clear();
        long time4 = getTimeForGettingStrings(shortener2, ids, origStrings);
        Assert.assertEquals(time3, time4, 5);
    }
}
