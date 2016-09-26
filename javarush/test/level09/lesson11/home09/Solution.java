package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Cat c1 = new Cat("cat1");
        Cat c2 = new Cat("cat2");
        Cat c3 = new Cat("cat3");
        Cat c4 = new Cat("cat4");
        Cat c5 = new Cat("cat5");
        Cat c6 = new Cat("cat6");
        Cat c7 = new Cat("cat7");
        Cat c8 = new Cat("cat8");
        Cat c9 = new Cat("cat9");
        Cat c10 = new Cat("cat10");
        Map<String, Cat> map1 = new HashMap<>();
        map1.put(c1.toString(),c1);
        map1.put(c2.toString(),c2);
        map1.put(c3.toString(),c3);
        map1.put(c4.toString(),c4);
        map1.put(c5.toString(),c5);
        map1.put(c6.toString(),c6);
        map1.put(c7.toString(),c7);
        map1.put(c8.toString(),c8);
        map1.put(c9.toString(),c9);
        map1.put(c10.toString(),c10);
        return map1;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set1 = new HashSet<>();
        Iterator<Map.Entry<String, Cat>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Cat> pair = iterator.next();
            Cat cat = pair.getValue();
            set1.add(cat);
        }
        return set1;//напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
