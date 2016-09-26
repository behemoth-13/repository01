package com.javarush.test.level20.lesson10.home03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A(){
            this.name = "";
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            int len = s.readInt();
            for (int i = 0; i < len; i++) {
                this.name += s.readChar();
            }
        }
        private void writeObject(ObjectOutputStream out) throws IOException
        {
            out.defaultWriteObject();
            out.writeInt(name.length());
            out.writeChars(name);
        }
    }
}
