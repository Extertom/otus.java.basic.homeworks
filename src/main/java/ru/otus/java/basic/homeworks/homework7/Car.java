package ru.otus.java.basic.homeworks.homework7;

public class Car extends Transport {
    private double fuel;
    private final double maxFuel;
    private final double fuelConsumption;

    public Car(String name, double maxFuel, double fuelConsumption) {
        super(name);
        this.fuel = maxFuel;
        this.maxFuel = maxFuel;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.DENSE_FOREST || terrain == TerrainType.SWAMP) {
            System.out.println("Машина " + name + " не может перемещаться по " + terrain.getDescription());
            return false;
        }
        double requiredFuel = distance * fuelConsumption;
        if (fuel < requiredFuel) {
            System.out.println("Недостаточно топлива в машине '" + name + "'. Нужно: " + requiredFuel + "л, имеется: " + fuel + "л.");
            return false;
        }
        fuel -= requiredFuel;
        System.out.println("Машина " + name + " проехала " + distance + "км. по " + terrain.getDescription() + ". Израсходовано: " + requiredFuel + "л. Осталось топлива: " + fuel + "л.");
        return true;
    }

    @Override
    public String getStatus() {
        return "Машина " + name + ", топливо: " + fuel + "/" + maxFuel + "л.";
    }

    public void refuel(double amount) {
        fuel = Math.min(fuel + amount, maxFuel);
        System.out.println("Машина " + name + " заправлена. Топливо: " + fuel + "/" + maxFuel + "л.");
    }
}
