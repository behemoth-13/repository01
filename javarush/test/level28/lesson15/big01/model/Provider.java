package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 04.08.2016.
 */
public class Provider
{
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString)
    {
        ArrayList list = new ArrayList<>();
        try
        {
            list = (ArrayList)strategy.getVacancies(searchString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }
}
