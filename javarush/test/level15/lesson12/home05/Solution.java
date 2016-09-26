package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution(int x){}
    private Solution(int x, int y){}
    private Solution(int x, int y, int z){}
    Solution(double x){}
    Solution(double x, double y){}
    Solution(double x, double y, double z){}
    protected Solution(float x){}
    protected Solution(float x, float y){}
    protected Solution(float x, float y, float z){}
    public Solution(long x){}
    public Solution(long x, long y){}
    public Solution(long x, long y, long z){}
}

