package com.javarush.test.level14.lesson08.bonus01;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);//1
        }
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);//1
        }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }try
    {
        float i = 1 / 0;

    } catch (Exception e)
    {
        exceptions.add(e);//1
    }
        //Add your code here

    }
}
