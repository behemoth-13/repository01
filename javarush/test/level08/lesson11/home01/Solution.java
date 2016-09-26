package com.javarush.test.level08.lesson11.home01;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{

    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Iterator<Cat> iterator = cats.iterator();
        Cat catRemove = iterator.next();
        cats.remove(catRemove);//напишите тут ваш код. пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> set = new HashSet<Cat>();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        set.add(cat1);
        set.add(cat2);
        set.add(cat3);//напишите тут ваш код. пункт 2
        return set;
    }

    public static void printCats(Set<Cat> cats)
    {
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext())
        {
            Cat cat = iterator.next();
            System.out.println(cat);// пункт 4
        }
    }

    public static class Cat
    {

    }// пункт 1
}
