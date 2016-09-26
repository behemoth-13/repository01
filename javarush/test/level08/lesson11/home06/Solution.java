package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children = new ArrayList<Human>();
        Human child1 = new Human("Тимур", true, 23, children);
        Human child2 = new Human("Константин", true, 18, children);
        Human child3 = new Human("Сергей", true, 27, children);
        ArrayList<Human> children3 = new ArrayList<Human>();
        children3.add(child1);
        children3.add(child2);
        children3.add(child3);
        Human father = new Human("Александр", true, 40, children3);
        Human mother = new Human("Любовь", false, 40, children3);
        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(father);
        Human grandfather1 = new Human("Николай", true, 67, children1);
        Human grandmother1 = new Human("Валентина", false, 65, children1);
        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(mother);
        Human grandfather2 = new Human("Василий", true, 72, children2);
        Human grandmother2 = new Human("Виктория", false, 71, children2);


        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        public Human(String name,boolean sex, int age, ArrayList<Human> children)
        {

            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }


        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
