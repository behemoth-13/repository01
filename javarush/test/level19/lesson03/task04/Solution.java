package com.javarush.test.level19.lesson03.task04;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.


public class Solution {
    public static class PersonScannerAdapter {

    }
}*/
public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scr;
        public PersonScannerAdapter(Scanner scanner){
            this.scr = scanner;
        }
        @Override
        public Person read() throws IOException
        {
            String s =scr.nextLine();
            Scanner scan = new Scanner(s);
            String lastName = scan.next();
            String firstName = scan.next();
            String middleName = scan.next();
            Date date = null;
            try{date = new SimpleDateFormat("ddMMyyyy").parse(""+scan.next()+scan.next()+scan.next());}catch (ParseException r){}
            return new Person(firstName,middleName, lastName, date);
        }

        @Override
        public void close() throws IOException
        {
            scr.close();
        }
    }
}