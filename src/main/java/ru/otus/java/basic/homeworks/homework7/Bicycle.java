package ru.otus.java.basic.homeworks.homework7;

public class Bicycle extends AbstractTransport{
    private int riderStamina;
    private final int maxRiderStamina;
    private final int staminaConsumption;

    public Bicycle(String name, int maxRiderStamina, int staminaConsumption) {
        super(name);
        this.maxRiderStamina = maxRiderStamina;
        this.riderStamina = maxRiderStamina;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Велосипед " + getName() + " не может перемещаться по " + terrain.getDescription());
            return false;
        }

        int consumptionMultiplier = (terrain == TerrainType.DENSE_FOREST) ? 2 : 1;
        int requiredStamina = distance * staminaConsumption * consumptionMultiplier;

        if (riderStamina < requiredStamina) {
            System.out.println("Велосипедист слишком устал. Нужно сил: " +
                    requiredStamina + ", имеется: " + riderStamina);
            return false;
        }

        riderStamina -= requiredStamina;
        System.out.println("Велосипед " + getName() + " проехал " + distance +
                " км по " + terrain.getDescription() + ". Потрачено сил: " +
                requiredStamina + ". Осталось сил: " + riderStamina);
        return true;
    }

    @Override
    public String getStatus() {
        return "Велосипед " + getName() + ", силы всадника: " + riderStamina + "/" + maxRiderStamina;
    }
}
