package com.javarush.test.level22.lesson05.task02;

import java.util.ArrayList;
import java.util.List;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null)
            throw new TooShortStringException();
        String result = null;
        List<Integer> indexesOfProbel = new ArrayList<>();
        char[] temp = string.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '\t') {
                indexesOfProbel.add(i);
            }
        }
        try {
            result = string.substring(indexesOfProbel.get(0) + 1, indexesOfProbel.get(1));
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
