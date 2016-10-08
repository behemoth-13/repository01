package com.javarush.test.level34.lesson15.big01.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 07.10.2016.
 */
public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        //создание контейнеров для всех объектов
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        //определение уровня
        int trueLevel = level % 60;
        if (trueLevel == 0) {
            trueLevel = 60;
        }

        //чтение файла
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(levels.toFile()))) {
            int currentLevel = 0;
            String line = bufferedReader.readLine();
            while (currentLevel != trueLevel) {
                if (line.equals("*************************************"))
                    currentLevel++;
                line = bufferedReader.readLine();
            }
            bufferedReader.readLine();
            int sizeX = findSizeXorY(bufferedReader);
            int sizeY = findSizeXorY(bufferedReader);
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            for (int i = 0; i < sizeY; i++) {
                String s = bufferedReader.readLine();
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    /*Символ ‘X’ –
                    означает стену, ‘*’ - ящик, ‘.’ – дом, ‘&’ – ящик который стоит в доме, а ‘@’ - игрока.*/
                    switch (chars[j]) {
                        case 'X':
                            walls.add(new Wall(getCoord(j), getCoord(i)));
                            break;
                        case '*':
                            boxes.add(new Box(getCoord(j), getCoord(i)));
                            break;
                        case '.':
                            homes.add(new Home(getCoord(j), getCoord(i)));
                            break;
                        case '&':
                            boxes.add(new Box(getCoord(j), getCoord(i)));
                            homes.add(new Home(getCoord(j), getCoord(i)));
                            break;
                        case '@':
                            player = new Player(getCoord(j), getCoord(i));
                            break;
                    }
                }
            }
            //System.out.println(bufferedReader.readLine());
        }
        catch (FileNotFoundException e) {
            System.out.println("Не зашёл в файл");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения данных из файла");
        }
        return new GameObjects(walls, boxes, homes, player);
    }

    private int findSizeXorY(BufferedReader bufferedReader) throws IOException {
        String containsSizeXorY = bufferedReader.readLine();
        String XorY = containsSizeXorY.substring(containsSizeXorY.indexOf("Size ") + 8);
        return Integer.parseInt(XorY);
    }

    private int getCoord(int iter) {
        if (iter == 0)
            return Model.FIELD_SELL_SIZE / 2;
        else
            return iter * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2;
    }

}

/*int stepSize = Model.FIELD_SELL_SIZE / 2;
*************************************
Maze: 1
File offset: 148C, DS:00FC, table offset: 0000
Size X: 22
Size Y: 11
End: 14BD
Length: 50

    XXXXX
    X   X
    X*  X
  XXX  *XXX
  X  *  * X
XXX X XXX X     XXXXXX
X   X XXX XXXXXXX  ..X
X *  *             ..X
XXXXX XXXX X@XXXX  ..X
    X      XXX  XXXXXX
    XXXXXXXX

*************************************
Maze: 2


16.1.	Открой файл levels.txt и внимательно изучи структуру файла. Символ ‘X’ –
        означает стену, ‘*’ - ящик, ‘.’ – дом, ‘&’ – ящик который стоит в доме, а ‘@’ - игрока.
        Всего в файле 60 уровней.
        16.2.	Реализуй метод GameObjects getLevel(int level). Он должен:
        16.2.1.	Вычитывать из файла данные уровня level. Уровни должны повторяться
        циклически, если пользователь прошел все 60 уровней и попал на 61 уровень, то
        ему нужно вернуть 1, вместо 62 уровня вернуть 2 и т.д.
        16.2.2.	Создать все игровые объекты, описанные в указанном уровне. Координаты
        каждого игрового объекта должны быть рассчитаны согласно следующей логике:
        16.2.2.1.	Самый верхний левый объект (если такой есть) должен иметь
        координаты x = x0 = FIELD_SELL_SIZE / 2 и y = y0 = FIELD_SELL_SIZE / 2.
        16.2.2.2.	Объект, который находится на одну позицию правее от него должен
        иметь координаты x = x0 + FIELD_SELL_SIZE и y = y0.
        16.2.2.3.	Объект, который находится на одну позицию ниже от самого верхнего
        левого должен иметь координаты x = x0 и y = y0 + FIELD_SELL_SIZE.
        16.2.2.4.	Аналогично должны рассчитываться координаты любого объекта на
        поле.
        16.2.3.	Создать новое хранилище объектов GameObjects и поместить в него все
        объекты.
        16.2.4.	Вернуть созданное хранилище.

        Игра должна быть полностью рабочей. Проверь, если есть какие-то проблемы исправь их.*/
