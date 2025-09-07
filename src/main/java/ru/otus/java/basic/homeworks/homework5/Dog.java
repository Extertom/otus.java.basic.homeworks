package ru.otus.java.basic.homeworks.homework5;

public class Dog extends Animal{
    public Dog(String name, double runSpeed, double swimSpeed, int stamina) {
        super(name, runSpeed, swimSpeed, stamina);
    }

    @Override
    public double swim(int distance) {
        if (isTired) {
            System.out.println(name + " слишком устал(а) для плавания!");
            return -1;
        }

        int staminaCost = distance * 2;
        if (staminaCost > stamina) {
            System.out.println(name + " не может проплыть " + distance + " м. Не хватает выносливости!");
            isTired = true;
            return -1;
        }

        stamina -= staminaCost;
        double time = distance / swimSpeed;

        System.out.println(name + " проплыл(а) " + distance + " м за " +
                String.format("%.2f", time) + " сек. Затрачено " + staminaCost + " ед. выносливости.");

        return time;
    }
}
