package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    static List<Word> result = new ArrayList<Word>();
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        for (Word word: result)
        {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<Word>();
        for (String word : words)
        {
            /////
            ArrayList<Pair> coords = new ArrayList<>();
            for (int x = 0; x < crossword.length; x++)
            {
                for (int y = 0; y < crossword[0].length; y++)
                {
                    if (word.charAt(0) == crossword[x][y])
                        coords.add(new Pair(x, y));
                }
            }
            for (Pair pair : coords)//для каждой совпадающей буквы
            {
                check(0, 1, pair, word, crossword);
                check(0, -1, pair, word, crossword);
                check(1, 0, pair, word, crossword);
                check(1, 1, pair, word, crossword);
                check(1, -1, pair, word, crossword);
                check(-1, 0, pair, word, crossword);
                check(-1, 1, pair, word, crossword);
                check(-1, -1, pair, word, crossword);
            }
        }
        return Solution.result;
    }

    public static class Pair{
        private int x;
        private int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void check(int dx, int dy, Pair pair, String word, int[][] crossword){//dx, dy -- смещение, pair -- начальные координаты
        int count = 1;
        int x = pair.x;
        int y = pair.y;
        for (int i = 1; i < word.length(); i++)
        {
            x = x + dx;
            y = y + dy;
            if (x >= 0 && y >=0 && x < crossword.length && y < crossword[x].length)
            {
                if (word.charAt(i) == crossword[x][y])
                {
                    count++;
                }
            }
        }
        if (count == word.length())
        {
            Word wordObject = new Word(word);
            wordObject.setStartPoint(pair.y, pair.x);
            wordObject.setEndPoint(y, x);
            result.add(wordObject);
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
