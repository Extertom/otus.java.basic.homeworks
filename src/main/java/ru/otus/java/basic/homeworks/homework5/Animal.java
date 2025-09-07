package ru.otus.java.basic.homeworks.homework5;

public class Animal {
    protected String name;
    protected double runSpeed;
    protected double swimSpeed;
    protected int stamina;
    protected int maxStamina;
    protected boolean isTired;

    public Animal(String name, double runSpeed, double swimSpeed, int stamina) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.stamina = stamina;
        this.maxStamina = stamina;
        this.isTired = false;
    }

    public double run(int distance) {
        if (isTired) {
            System.out.println(name + " слишком устал(а) для бега!");
            return -1;
        }

        int staminaCost = distance;
        if (staminaCost > stamina) {
            System.out.println(name + " не может пробежать " + distance + " м. Не хватает выносливости!");
            isTired = true;
            return -1;
        }

        stamina -= staminaCost;
        double time = distance / runSpeed;

        System.out.println(name + " пробежал(а) " + distance + " м за " +
                String.format("%.2f", time) + " сек. Затрачено " + staminaCost + " ед. выносливости.");

        return time;
    }

    public double swim(int distance) {
        if (isTired) {
            System.out.println(name + " слишком устал(а) для плавания!");
            return -1;
        }

        System.out.println(name + " не умеет плавать!");
        return -1;
    }

    public void info() {
        System.out.println(name + ": " +
                "Выносливость " + stamina + "/" + maxStamina +
                ", Состояние: " + (isTired ? "Устал(а)" : "Бодр(а)"));
    }

    public void rest() {
        stamina = maxStamina;
        isTired = false;
        System.out.println(name + " отдохнул(а) и восстановил(а) силы!");
    }

    public String getName() {
        return name;
    }

    public boolean isTired() {
        return isTired;
    }
}
