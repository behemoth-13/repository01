package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990


public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}*/
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        String name;
        String sex;
        Date bd = null;
        int id;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c"))
        {
            name = args[1];
            sex  = args[2];
            try
            {
                bd = dateFormat.parse(args[3]);
            }
            catch (ParseException e){}
            if (sex.equals("м"))
            {
                allPeople.add(Person.createMale(name, bd));
            }
            else if (sex.equals("ж"))
            {
                allPeople.add(Person.createFemale(name, bd));
            }
            System.out.println(allPeople.size() - 1);
        }
        else if (args[0].equals("-u"))
        {
            id  = Integer.parseInt(args[1]);
            name = args[2];
            sex = args[3];
            try
            {
                bd = dateFormat.parse(args[4]);
            }
            catch (ParseException e){}
            if (sex.equals("м"))
            {
                allPeople.set(id, Person.createMale(name, bd));
            }
            else if (sex.equals("ж"))
            {
                allPeople.set(id, Person.createFemale(name, bd));
            }
        }
        else if (args[0].equals("-d"))
        {
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }
        else if (args[0].equals("-i"))
        {
            id  = Integer.parseInt(args[1]);
            name = allPeople.get(id).getName();
            sex = (allPeople.get(id).getSex().equals(Sex.MALE)) ? "м" : "ж";
            SimpleDateFormat sdfr = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String dateOfBirth = sdfr.format(allPeople.get(id).getBirthDay());
            System.out.println(name + " " + sex + " " + dateOfBirth);
        }
    }
}
/*switch(args[0]){
            case "-c" :{

                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
                    switch (args[2])
                    {
                        case "м":
                        {
                            allPeople.add(allPeople.size(), Person.createMale(args[1], date));
                            break;
                        }
                        case "ж":
                        {
                            allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[1], date));
                            break;
                        }
                    }
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "-u" :{
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(args[4]);
                    switch (args[3])
                    {
                        case "м":
                        {
                            allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], date));
                            break;
                        }
                        case "ж":
                        {
                            allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], date));
                            break;
                        }
                    }
                break;
            }
            case "-d" :{
                    allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                    allPeople.get(Integer.parseInt(args[1])).setName(null);
                    allPeople.get(Integer.parseInt(args[1])).setSex(null);
                break;
            }
            case "-i" :{
                Person person = allPeople.get(Integer.parseInt(args[1]));
                Sex sex = person.getSex();
                String sexstr = null;
                if (sex.equals(Sex.FEMALE))
                    sexstr = "ж";
                else if (sex.equals(Sex.MALE))
                    sexstr = "м";
                Date date = person.getBirthDay();
                SimpleDateFormat ad = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);;
                System.out.println(person.getName() + " " + sexstr + " "+ ad.format(date));
                break;
            }
        }
    }
}*/