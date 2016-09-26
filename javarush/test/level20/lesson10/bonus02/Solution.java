package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        while (!isClear(a)){
            for (int i = 0; i < a.length; i++){
                for (int j = 0; j < a[i].length; j++){
                    if (a[i][j] ==1 ){
                        ArrayList<Point> removeRectangle = getRectagleCoords(new Point(i,j), a);
                        for (Point p : removeRectangle){
                            a[p.i][p.j] = 0;
                        }
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static ArrayList<Point> getRectagleCoords(Point start, byte[][] a){
        int iStart = start.i;
        int jStart = start.j;
        int iFinish = start.i;
        int jFinish = 0;
        for (int j = jStart; j < a[1].length; j++){
            if (a[iStart][j] == 1){
                jFinish = j;
            }
            else
                break;
        }
        for (int i = iStart + 1; i < a.length; i++){
            boolean all = true;
            for (int j = jStart; j <= jFinish; j++){
                if (a[i][j] == 0)
                    all = false;
            }
            if (all)
                iFinish = i;
            else
                break;
        }


        return getCoords(start, new Point(iFinish, jFinish));
    }

    static ArrayList<Point> getCoords(Point start, Point finish){
        int iStart = start.i;
        int jStart = start.j;
        int iFinish = finish.i;
        int jFinish = finish.j;
        ArrayList<Point> list = new ArrayList<>();
        for (int i = iStart; i <= iFinish; i++){
            for (int j = jStart; j <= jFinish; j++){
                list.add(new Point(i, j));
            }
        }
        return list;
    }

    static boolean isClear(byte[][] a){
        boolean isClear = true;
        for (byte[] anA : a)
        {
            for (byte anAnA : anA)
            {
                if (anAnA == 1)
                    isClear = false;
            }
        }
        return isClear;
    }

    static class Point{
        private int i;
        private int j;

        public Point(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
}
