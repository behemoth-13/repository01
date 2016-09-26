package com.javarush.test.level32.lesson04.task01;

import java.io.PrintWriter;
import java.io.StringWriter;

/* Пишем стек-трейс
Реализуйте логику метода getStackTrace, который в виде одной строки должен возвращать весь стек-трейс переданного исключения.
Используйте подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}
//com.javarush.test.level32.lesson04.task01.Solution.main(Solution.java:11)sun.reflect.NativeMethodAccessorImpl.
// invoke0(Native Method)sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)sun.reflect.DelegatingMethodAccessorImpl.
// invoke(DelegatingMethodAccessorImpl.java:43)java.lang.reflect.Method.
// invoke(Method.java:497)com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
