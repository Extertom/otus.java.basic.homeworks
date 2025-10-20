package ru.otus.java.basic.homeworks.homework6;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Murzik", 20),
                new Cat("Strelka", 10),
                new Cat("Belka", 25)
        };
        System.out.println("=== Начальная ситуация ===");
        plate.info();
        for (Cat cat : cats) {
            cat.info();
        }
        System.out.println("\n=== Процесс питания ===");
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println();
        }
        System.out.println("=== Результат ===");
        plate.info();
        for (Cat cat : cats) {
            cat.info();
        }
        System.out.println("\n=== Добавляем еду и пробуем снова ===");
        plate.addFood(30);
        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                cat.eat(plate);

            }
        }
        for (Cat cat : cats) {
            cat.info();
        }
    }
}
