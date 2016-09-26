package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public synchronized static void c1(String[] args) throws ParseException
    {
        int i = (args.length - 1) / 3;
        for (int i1 = 0; i1 < i; i1++)
        {
            String name = args[1 + i1 * 3];
            String sex = args[2 + i1 * 3];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date bd = dateFormat.parse(args[3 + i1 * 3]);
            switch (sex)
            {
                case "м":
                {
                    allPeople.add(allPeople.size(),Person.createMale(name, bd));
                    break;
                }
                case "ж":
                {
                    allPeople.add(allPeople.size(),Person.createFemale(name, bd));
                    break;
                }
            }
            System.out.println(allPeople.size() - 1);
        }
    }
    public synchronized static void u1(String[] args) throws ParseException
    {
        int i = (args.length - 1) / 4;
        for (int i1 = 0; i1 < i; i1++)
        {
            int id = Integer.parseInt(args[1 + i1 * 4]);
            String name = args[2 + i1 * 4];
            String sex = args[3 + i1 * 4];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date bd = dateFormat.parse(args[4 + i1 * 4]);
            switch (sex)
            {
                case "м":
                {
                    allPeople.set(id, Person.createMale(name, bd));
                    break;
                }
                case "ж":
                {
                    allPeople.set(id, Person.createFemale(name, bd));
                    break;
                }
            }
        }
    }
    public synchronized static void d1(String[] args){
        int i = args.length - 1;
        for (int i1 = 0; i1 < i; i1++)
        {
            int id = Integer.parseInt(args[1 + i1]);
            allPeople.get(Integer.parseInt(args[id])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[id])).setName(null);
            allPeople.get(Integer.parseInt(args[id])).setSex(null);
        }
    }
    public synchronized static void i1(String[] args){
        for(int i=1;i<args.length;i++){
            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);}
    }
    public static void main(String[] args) throws ParseException
    {
        switch(args[0]){
            case "-c" :{
                c1(args);
                break;
            }
            case "-u" :{
                u1(args);
                break;
            }
            case "-d" :{
                d1(args);
                break;
            }
            case "-i" :{
                i1(args);
                break;
            }
        }//start here - начни тут
    }
}
/*public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, IndexOutOfBoundsException
    {
        if (args[0].equals("-c"))
        {
            int i = args.length - 1;
            if (i % 3 == 0)
                i = i / 3;
            else i = (i / 3) + 1;
            for (int i1 = 0; i1 < i; i1++)
            {
                String name = args[1 + i1 * 3];
                String sex = args[2 + i1 * 3];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date bd = dateFormat.parse(args[3 + i1 * 3]);
                if (sex.equals("м"))
                {
                    allPeople.add(allPeople.size(), Person.createMale(name, bd));
                }
                else if (sex.equals("ж"))
                {
                    allPeople.add(allPeople.size(), Person.createFemale(name, bd));
                }
            }
            System.out.println(allPeople.size() - 1);
        }
        else if (args[0].equals("-u"))
        {
                int i = args.length - 1;
                if (i % 3 == 0)
                    i = i / 3;
                else i = (i / 3) + 1;
                for (int i1 = 0; i1 < i; i1++)
                {
                    int id = Integer.parseInt(args[1 + i1 * 4]);
                    String name = args[2 + i1 * 4];
                    String sex = args[3 + i1 * 4];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date bd = dateFormat.parse(args[4 + i1 * 4]);
                    if (sex.equals("м"))
                        {
                            allPeople.set(id, Person.createMale(name, bd));
                        }
                    else if (sex.equals("ж"))
                        {
                            allPeople.set(id, Person.createFemale(name, bd));
                        }
                    }
                }
            else if (args[0].equals("-d")){
                int i = args.length - 1;
                for (int i1 = 0; i1 < i; i1++)
                {
                    int id = Integer.parseInt(args[1 + i1]);
                    allPeople.get(Integer.parseInt(args[id])).setBirthDay(null);
                    allPeople.get(Integer.parseInt(args[id])).setName(null);
                    allPeople.get(Integer.parseInt(args[id])).setSex(null);
                }
            }
            else if (args[0].equals("-i")){
                int i = args.length - 1;
                for (int i1 = 0; i1 < i; i1++)
                {
                    int id = Integer.parseInt(args[1 + i1]);
                    String name = allPeople.get(id).getName();
                    String sex = (allPeople.get(id).getSex().equals(Sex.MALE)) ? "м" : "ж";
                    SimpleDateFormat sdfr = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    String dateOfBirth = sdfr.format(allPeople.get(id).getBirthDay());
                    System.out.println(name + " " + sex + " " + dateOfBirth);
                }
            }
        }
        //start here - начни тут
    }

     int i = args.length - 1;
        for (int i1 = 0; i1 < i; i1++)
        {
            int id = Integer.parseInt(args[1 + i1]);
            allPeople.get(Integer.parseInt(args[id])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[id])).setName(null);
            allPeople.get(Integer.parseInt(args[id])).setSex(null);
        }
         for(int i=1;i<args.length;i++){
           allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);}*/