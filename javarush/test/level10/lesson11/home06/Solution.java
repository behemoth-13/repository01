package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        String firstname;
        int age;
        int strong;
        Human parent;
        Human child;
        Human (String name, int age)//1
        {
            this.name = name;
            this.age = age;
        }
        Human (String name, String firstname)//2
        {
            this.name = name;
            this.firstname = firstname;
        }
        Human (String name, int age, int strong)//3
        {
            this.name = name;
            this.age = age;
            this.strong = strong;
        }
        Human (String name, Human parent)//4
        {
            this.name = name;
            this.parent = parent;
        }
        Human (String name, Human parent, Human child)//5
        {
            this.name = name;
            this.parent = parent;
            this.child = child;
        }
        Human (Human parent, Human child)//6
        {
            this.parent = parent;
            this.child = child;
        }
        Human (String name, String firstname, Human parent, Human child)//7
        {
            this.name = name;
            this.firstname = firstname;
            this.parent = parent;
            this.child = child;
        }
        Human (String name, String firstname, Human parent, Human child, int age)//8
        {
            this.name = name;
            this.firstname = firstname;
            this.parent = parent;
            this.child = child;
            this.age = age;
        }
        Human (Human parent, Human child, int age)//9
        {
            this.parent = parent;
            this.child = child;
            this.age = age;
        }
        Human (String name)//10
        {
            this.name = name;
        }
        //напишите тут ваши переменные и конструкторы
    }
}
