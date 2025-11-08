package ru.otus.java.basic.homeworks.homework7;

public class AllTerrainVehicle extends AbstractTransport {
    private double fuel;
    private final double maxFuel;
    private final double fuelConsumption;

    public AllTerrainVehicle(String name, double maxFuel, double fuelConsumption) {
        super(name);
        this.maxFuel = maxFuel;
        this.fuel = maxFuel;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        double terrainMultiplier = switch (terrain) {
            case SWAMP -> 2.0;
            case DENSE_FOREST -> 1.5;
            case PLAIN -> 1.0;
        };

        double requiredFuel = distance * fuelConsumption * terrainMultiplier;

        if (fuel < requiredFuel) {
            System.out.println("Недостаточно топлива в вездеходе " + getName() + ". Нужно: " +
                    requiredFuel + "л, имеется: " + fuel + "л");
            return false;
        }

        fuel -= requiredFuel;
        System.out.println("Вездеход " + getName() + " проехал " + distance +
                " км по " + terrain.getDescription() + ". Израсходовано: " +
                requiredFuel + "л. Осталось топлива: " + fuel + "л");
        return true;
    }

    @Override
    public String getStatus() {
        return "Вездеход " + getName() + ", топливо: " + fuel + "/" + maxFuel + "л";
    }

}
