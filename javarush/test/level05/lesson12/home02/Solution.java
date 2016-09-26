package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{

public static void main(String[] args)
        {
        Man man1 = new Man("Kolya", 28, "Kiev");
        Man man2 = new Man("Vasya", 24, "Lvov");
        Woman wom1 = new Woman("Ko",34,"Kit");
        Woman wom2 = new Woman("Kol",45,"Hyy");// Создай по два объекта каждого класса тут
        System.out.println(man1);// Выведи их на экран тут
        System.out.println(man2);
        System.out.println(wom1);// Выведи их на экран тут
        System.out.println(wom2);// Выведи их на экран тут
        // Выведи их на экран тут
        }
public static class Man
{
    private String name;
    private int age;
    private String address;
    public Man(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String toString(){
        String a = name + " " + age + " " + address;
        return a;
    }
}
public static class Woman
{
    private String name;
    private int age;
    private String address;
    public Woman(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String toString(){
        String a = name + " " + age + " " + address;
        return a;
    }
}
}