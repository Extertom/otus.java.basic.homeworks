package ru.otus.java.basic.homeworks.homework6;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate) {
        if (!satiety) {
            System.out.println(name + " подошел к тарелке...");
            if (plate.decreaseFood(appetite)) {
                satiety = true;
                System.out.println(name + " поел и теперь сыт!");
            } else {
                System.out.println(name + " не стал есть - слишком мало еды!");
            }
        } else {
            System.out.println(name + " уже сыт и не хочет есть.");
        }
    }

    public void info() {
        String status = satiety ? "сыт" : "голоден";
        System.out.println("Кот " + name + " (аппетит: " + appetite + "): " + status);

    }
}
