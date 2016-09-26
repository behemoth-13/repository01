package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 07.08.2016.
 */
public class Model
{
    private View view;
    private Provider[] providers;

    public Model(View view, Provider[] providers)
    {
        if (view == null || providers == null || providers.length == 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.view = view;
            this.providers = providers;
        }
    }

    public void selectCity(String city)
    {
        if (view == null || providers == null || providers.length == 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            List<Vacancy> list = new ArrayList<>();
            for (Provider provider : providers)
            {
                list.addAll(provider.getJavaVacancies(city));
            }
            view.update(list);
        }
    }
}
