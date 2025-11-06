package ru.otus.java.basic.homeworks.homework7;

public class AllTerrainVehicle extends Transport {
    private double fuel;
    private final double maxFuel;
    private final double fuelConsumption;

    public AllTerrainVehicle(String name, double maxFuel, double fuelConsumption) {
        super(name);
        this.fuel = maxFuel;
        this.maxFuel = maxFuel;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        double terrainMultiplier = 1.0;
        if (terrain == TerrainType.SWAMP) terrainMultiplier = 2.0;
        if (terrain == TerrainType.DENSE_FOREST) terrainMultiplier = 1.5;
        double requiredFuel = distance * fuelConsumption * terrainMultiplier;

        if (fuel < requiredFuel) {
            System.out.println("Недостаточно топлива в вездеходе '" + name + "'. Нужно: " + requiredFuel + "л, имеется: " + fuel + "л.");
            return false;
        }
        fuel -= requiredFuel;
        System.out.println("Вездеход '" + name + "' проехал " + distance + "км. по " + terrain.getDescription() + ". Израсходовано: " + requiredFuel + "л. Осталось топлива: " + fuel + "л.");
        return true;
    }

    @Override
    public String getStatus() {
        return "Вездеход '" + name + "', топливо: " + fuel + "/" + maxFuel + "л.";
    }

    public void refuel(double amount) {
        fuel = Math.min(fuel + amount, maxFuel);
        System.out.println("Вездеход '" + name + "' заправлен. Топливо: " + fuel + "/" + maxFuel + "л.");
    }
}
