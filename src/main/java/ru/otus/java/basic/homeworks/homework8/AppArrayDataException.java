package ru.otus.java.basic.homeworks.homework8;

class AppArrayDataException extends Exception {
    AppArrayDataException(int i, int j, String v) {
        super("Ошибка в [" + i + "][" + j + "]: '" + v + "'");
    }
}
