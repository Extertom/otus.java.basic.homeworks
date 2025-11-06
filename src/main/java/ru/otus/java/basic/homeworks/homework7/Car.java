package ru.otus.java.basic.homeworks.homework7;

public class Car extends AbstractTransport{
    private double fuel;
    private final double maxFuel;
    private final double fuelConsumption;

    public Car(String name, double maxFuel, double fuelConsumption) {
        super(name);
        this.maxFuel = maxFuel;
        this.fuel = maxFuel;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.DENSE_FOREST || terrain == TerrainType.SWAMP) {
            System.out.println("Машина " + getName() + " не может перемещаться по " + terrain.getDescription());
            return false;
        }

        double requiredFuel = distance * fuelConsumption;
        if (fuel < requiredFuel) {
            System.out.println("Недостаточно топлива в машине " + getName() + ". Нужно: " +
                    requiredFuel + "л, имеется: " + fuel + "л");
            return false;
        }

        fuel -= requiredFuel;
        System.out.println("Машина " + getName() + " проехала " + distance +
                " км по " + terrain.getDescription() + ". Израсходовано: " +
                requiredFuel + "л. Осталось топлива: " + fuel + "л");
        return true;
    }

    @Override
    public String getStatus() {
        return "Машина " + getName() + ", топливо: " + fuel + "/" + maxFuel + "л";
    }
}
