package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 30.06.2016.
 */
public class CurrencyManipulatorFactory
{
    private static HashMap<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (map.containsKey(currencyCode))
            return map.get(currencyCode);
        else
        {
            CurrencyManipulator c = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, c);
            return c;
        }
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        Collection<CurrencyManipulator> cl = new ArrayList<CurrencyManipulator>();
        for (Map.Entry pair : map.entrySet())
        {
            cl.add((CurrencyManipulator)pair.getValue());
        }
        return cl;
    }


    private CurrencyManipulatorFactory()
    {

    }
}
