package ru.otus.java.basic.homeworks.homework7;

public class Bicycle extends Transport {
    private int riderStamina;
    private final int maxRiderStamina;
    private final int staminaConsumption;

    public Bicycle(String name, int staminaConsumption, int maxRiderStamina) {
        super(name);
        this.staminaConsumption = staminaConsumption;
        this.maxRiderStamina = maxRiderStamina;
        this.riderStamina = maxRiderStamina;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Велосипед " + name + " не может перемещаться по " + terrain.getDescription());
            return false;
        }
        int requiredStamina = distance * staminaConsumption;
        int consumptionMultiplier = (terrain == TerrainType.DENSE_FOREST) ? 2 : 1;
        int actualConsumption = requiredStamina * consumptionMultiplier;

        if (riderStamina < actualConsumption) {
            System.out.println("Велосипедист слишком устал. Нужно сил: " + actualConsumption + " имеется: " + riderStamina);
            return false;
        }
        riderStamina -= actualConsumption;
        System.out.println("Велосипед " + name + " проехал " + distance + "км. по " + terrain.getDescription() + ". Потрачено сил: " + actualConsumption + " Осталось сил: " + riderStamina);
        return true;
    }

    @Override
    public String getStatus() {
        return "Велосипед " + name + ", силы всадника: " + riderStamina + "/" + maxRiderStamina;
    }

    public void rest() {
        riderStamina = maxRiderStamina;
        System.out.println("Велосипедист отдохнул. Силы восстановлены: " + riderStamina + "/" + maxRiderStamina);
    }
}
