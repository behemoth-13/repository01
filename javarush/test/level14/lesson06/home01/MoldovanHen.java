package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 11.03.2016.
 */
public class MoldovanHen extends Hen
{

    int getCountOfEggsPerMonth()
    {
        return 6;
    }
    String getDescription()
    {
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() +  " яиц в месяц.");
    }
}
