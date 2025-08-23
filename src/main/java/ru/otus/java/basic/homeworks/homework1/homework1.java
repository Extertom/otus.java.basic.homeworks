package ru.otus.java.basic.homeworks.homework1;

import java.util.Random;
import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        greetings();
        checkSing(2, 3, 6);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(15, 8, false);
        addOrSubtractAndPrint(15, 8, true);
        numberSelection();

    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSing(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = new Random().nextInt(25) + 1;
        if (data <= 10) {
            System.out.println("Красный");
        }
        if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        }
        if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = new Random().nextInt(50) + 1;
        int b = new Random().nextInt(50) + 1;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }

    public static void numberSelection() {
        System.out.println("Введите число от 1 до 5, чтобы выбрать метод:");
        Scanner keyboard = new Scanner(System.in);
        int inputNumber, a, b, c, initValue, delta;
        boolean increment;
        inputNumber = keyboard.nextInt();
        a = (int) (Math.random() * 20 - 10);
        b = (int) (Math.random() * 20 - 10);
        c = (int) (Math.random() * 20 - 10);
        initValue = (int) (Math.random() * 10);
        delta = (int) (Math.random() * 10);
        increment = new Random().nextBoolean();

        switch (inputNumber) {
            case 1:
                greetings();
                break;
            case 2:
                checkSing(a, b, c);
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                addOrSubtractAndPrint(initValue, delta, increment);
                break;
            default:
                System.out.println("Ошибка!!!");
        }


    }


}
