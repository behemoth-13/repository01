package com.javarush.test.level20.lesson10.bonus01;

import java.util.*;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
На выполнение дается 10 секунд и 50 МБ памяти.

Calculating time: 18778
*/
public class SolutionMy {

    private static int[][] table;

    public static void main(String[] args) {
        int number = 1000000000;
        long freeMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        initTable(number);
        int[] a = getNumbers(number);
        long memoryAfterCalculate = Runtime.getRuntime().freeMemory();
        long delta = memoryAfterCalculate - freeMemory;
        long stopTime = System.currentTimeMillis();
        System.out.println("Calculating time: " + (stopTime - startTime));
        System.out.println("Used JVM memory: " + delta);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initTable(int number) {
        int columnCount = 1 + (int) Math.log10(number);
        table = new int[10][columnCount];
        for (int i = 0; i < columnCount; i++) {
            table[1][i] = 1;
        }
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < columnCount; ) {
                table[i][j] = (int) Math.pow(i, ++j);
            }
        }
    }

    private static int checkFormula(int number) {
        int rest = number,
                sum = 0,
                digit,
                digitCount = (int) Math.log10(number);
        for (int i = 0; i <= digitCount; i++) {
            digit = rest % 10;
            rest = rest / 10;
            sum += table[digit][digitCount];
        }
        if (sum == number) {
            return number;
        }
        while (number % 10 == 0) {
            number = number / 10;
        }
        if (sum < number) {
            return -1;
        }
        return checkFormula2(sum, digitCount);
    }

    private static int checkFormula2(int number, int digitCount) {
        int rest = number,
                sum = 0,
                digit;
        for (int i = 0; i <= digitCount; i++) {
            digit = rest % 10;
            rest = rest / 10;
            sum += table[digit][digitCount];
        }
        if (sum == number)
            return number;
        else
            return -1;
    }

    public static int[] getNumbers(int max) {
        Set<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 1; i <= max; i++) {
            int j = i;
            while (j % 10 == 0) {
                j = j / 10;
            }
            int k = j % 10;
            boolean b = true;
            while (j / 10 != 0) {
                j = j / 10;
                if (j % 10 <= k) {
                    k = j % 10;
                } else {
                    b = false;
                    break;
                }
            }
            if (b) {
                int jk = checkFormula(i);
                if (jk != -1) {
                    set.add(jk);
                }
            }
        }
        int[] longs = new int[set.size()];
        int i = 0;
        for (int i2 : set) {
            longs[i++] = i2;
        }
        return longs;
    }
}