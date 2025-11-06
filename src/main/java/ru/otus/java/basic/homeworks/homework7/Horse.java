package ru.otus.java.basic.homeworks.homework7;

public class Horse extends Transport {
    private int stamina;
    private final int maxStamina;
    private final int staminaConsumption;

    public Horse(String name, int staminaConsumption, int maxStamina) {
        super(name);
        this.staminaConsumption = staminaConsumption;
        this.maxStamina = maxStamina;
        this.stamina = maxStamina;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Лошадь " + name + " не может перемещаться по " + terrain.getDescription());
            return false;
        }
        int requiredStamina = distance * staminaConsumption;
        if (stamina < requiredStamina) {
            System.out.println("Лошадь " + name + " слишком устала. Нужно сил: " + requiredStamina + " имеется: " + stamina);
            return false;
        }
        stamina -= requiredStamina;
        System.out.println("Лошадь " + name + " проскакала " + distance + "км. по " + terrain.getDescription() + ". Потрачено сил: " + requiredStamina + " Осталось сил: " + stamina);
        return true;
    }

    @Override
    public String getStatus() {
        return "Лошадь " + name + ", силы: " + stamina + "/" + maxStamina;
    }

    public void rest() {
        stamina = maxStamina;
        System.out.println("Лошадь " + name + " отдохнула. Силы восстановлены: " + stamina + "/" + maxStamina);
    }
}
