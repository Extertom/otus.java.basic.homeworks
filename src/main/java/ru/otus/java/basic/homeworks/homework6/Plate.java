package ru.otus.java.basic.homeworks.homework6;

public class Plate {
    private final int maxFood;
    private int currentFood;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        this.currentFood = maxFood;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            currentFood += amount;
            if (currentFood > maxFood) {
                currentFood = maxFood;
            }
            System.out.println("В тарелку добавлено " + amount + " ед. еды. Теперь в тарелке : " + currentFood + " ед.");
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount < currentFood && amount > 0) {
            currentFood -= amount;
            System.out.println("Из тарелки взято: " + amount + " ед. еды. Осталось в тарелке : " + currentFood + "ед.");
            return true;
        }
        System.out.println("Нельзя взять " + amount + "ед. еды.! В тарелке только " + currentFood + " ед.");
        return false;
    }

    public void info() {
        System.out.println("Тарелка " + currentFood + "/" + maxFood + " ед. еды.");
    }
}
