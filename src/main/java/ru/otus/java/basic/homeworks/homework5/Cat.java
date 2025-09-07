package ru.otus.java.basic.homeworks.homework5;

public class Cat extends Animal {
    public Cat(String name, double runSpeed, int stamina) {
        super(name, runSpeed, 0, stamina);
    }

    @Override
    public double swim(int distance) {
        System.out.println(name + " не умеет плавать! Коты боятся воды.");
        return -1;
    }
}
