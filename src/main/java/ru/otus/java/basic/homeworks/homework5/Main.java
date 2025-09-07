package ru.otus.java.basic.homeworks.homework5;

public class Main {
    public static void main(String[] args) {
        // Создаем животных
        Cat cat = new Cat("Барсик", 5.0, 100);
        Dog dog = new Dog("Шарик", 8.0, 3.0, 200);
        Horse horse = new Horse("Буцефал", 10.0, 2.0, 500);

        System.out.println("=== Тест бега ===");
        cat.run(50);
        dog.run(100);
        horse.run(200);

        System.out.println("\n=== Тест плавания ===");
        cat.swim(10);
        dog.swim(20);
        horse.swim(30);

        System.out.println("\n=== Состояние животных ===");
        cat.info();
        dog.info();
        horse.info();

        System.out.println("\n=== Тест превышения выносливости ===");
        dog.run(150);
        dog.info();

        System.out.println("\n=== Отдых ===");
        dog.rest();
        dog.info();

        System.out.println("\n=== Повторная попытка ===");
        dog.run(100);
        dog.info();
    }
}
