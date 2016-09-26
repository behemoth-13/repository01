package com.javarush.test.level28.lesson06.home01;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alex on 28.07.2016.
 */
public class MyThread extends Thread
{
    private static AtomicInteger i1 = new AtomicInteger(0);

    private int getPR(ThreadGroup group){
        i1.set(i1.get() % 10 + 1);
        if (group == null)
        {
            return i1.get();
        }
        else {
            if (i1.get() <= group.getMaxPriority())
                return i1.get();
            else
                return group.getMaxPriority();
        }
    }

    public MyThread()
    {
        super();
        setPriority(getPR(null));
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority(getPR(null));
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setPriority(getPR(group));
    }

    public MyThread(String name)
    {
        super(name);
        setPriority(getPR(null));
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setPriority(getPR(group));
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority(getPR(null));
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setPriority(getPR(group));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setPriority(getPR(group));
    }
}
