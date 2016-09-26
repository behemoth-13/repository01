package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static class IncomeDataAdapter {
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}*/
import java.util.*;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData incomeData;
        public IncomeDataAdapter(IncomeData incomeData){
            this.incomeData = incomeData;
        }
        @Override
        public String getName()
        {
            return (incomeData.getContactLastName() + ", " + incomeData.getContactFirstName());
        }

        @Override

        public String getPhoneNumber()
        {
            char[] chars = Integer.toString(incomeData.getPhoneNumber()).toCharArray();
            ArrayList<Character> list = new ArrayList<Character>();
            for (int i = 0; i < chars.length; i++)
            {
                list.add(chars[i]);
            }
            if (list.size() < 10)
            {
                int i = 10 - list.size();
                for (int i1 = 0; i1 < i; i1++)
                    list.add(0, '0');
            }
            list.add(8, '-');
            list.add(6, '-');
            list.add(3, ')');
            list.add(0,'(');
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++)
            {
                sb.append(list.get(i));
            }

            return ("+" + incomeData.getCountryPhoneCode() + sb.toString() );
        }

        @Override
        public String getCompanyName()
        {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(incomeData.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}