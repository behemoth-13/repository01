package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(234d, "edhfs");
        labels.put(254d, "ss");
        labels.put(14d, "sf");
        labels.put(2234d, "ssdh");
        labels.put(2334d, "sfs");
    }

    public static void main(String[] args)
    {
        System.out.println(labels);
    }

}
