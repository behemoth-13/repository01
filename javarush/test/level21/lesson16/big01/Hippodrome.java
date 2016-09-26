package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Alex on 27.05.2016.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static Hippodrome game;

    public void run(){
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    public void move(){
        for (Horse horse : horses)
        {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses)
        {
            horse.print();
        }
        System.out.println();
    }

    public Horse getWinner(){
        Horse s = horses.get(0);
        for (int i = 1; i < horses.size(); i++)
        {
            if (s.getDistance() < horses.get(i).getDistance())
            {
                s = horses.get(i);
            }
        }
        return s;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Любаша", 3, 0));
        game.getHorses().add(new Horse("Лёшенька", 3, 0));
        game.getHorses().add(new Horse("Игорёк", 3, 0));
        game.run();
        game.printWinner();
    }
}
