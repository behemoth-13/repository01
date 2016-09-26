package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 11.03.2016.
 */
public class UkrainianHen extends Hen
{

    int getCountOfEggsPerMonth()
    {
        return 9;
    }
    String getDescription()
    {
        return (super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() +  " яиц в месяц.");
    }
}
