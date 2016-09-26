package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static
    {
        threads.add(new S1());
        threads.add(new S2());
        threads.add(new S3());
        threads.add(new S4());
        threads.add(new S5());
    }

public static class S1 extends Thread{
    @Override
    public void run()
    {
        while(true){}
    }
}
    public static class S2 extends Thread{
    @Override
    public void run()
    {
        try
        {
            while (true)
            sleep(0);
        }
        catch (InterruptedException e)
        {
            System.out.println("InterruptedException");
        }

    }
}
    public static class S3 extends Thread{
    @Override
    public void run()
    {
        while(!isInterrupted())
        {
            System.out.println("Ура");
            try
            {
                sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
    public static class S4 extends Thread implements Message{

    @Override
    public  void showWarning()
    {
        try
        {
            this.interrupt();
            this.join();
        }
        catch (Exception e)
        {
        }
    }
    public void run() {
        while (!isInterrupted()){
        }
    }
}
    public static class S5 extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        public void run() {
            try {
                String line = reader.readLine();
                int sum = 0;
                while (!line.equals("N")){
                    sum += Integer.parseInt(line);
                    line = reader.readLine();
                }
                System.out.println(sum);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/*{
    @Override
    public void run()
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<String> list = new ArrayList<String>();
        String text = null;
        try
        {
            text = reader.readLine();
        }
        catch (IOException e){}
        int summ = 0;
            int temp = 0;
            while (!text.equals("N"))
            {
                list.add(text);
                try
                {
                    text = reader.readLine();
                }
                catch (IOException e){}
            }
        try
        {
            reader.close();
        }
        catch (IOException e){}
        for (String s: list)
            {
                try
                {
                    temp = Integer.parseInt(s);
                }
                catch(Exception e){}
                summ = summ + temp;
                temp = 0;
            }


    }
}}*/