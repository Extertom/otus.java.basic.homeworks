package ru.otus.java.basic.homeworks.homework7;

public class Horse extends AbstractTransport{
    private int stamina;
    private final int maxStamina;
    private final int staminaConsumption;

    public Horse(String name, int maxStamina, int staminaConsumption) {
        super(name);
        this.maxStamina = maxStamina;
        this.stamina = maxStamina;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Лошадь " + getName() + " не может перемещаться по " + terrain.getDescription());
            return false;
        }

        int requiredStamina = distance * staminaConsumption;
        if (stamina < requiredStamina) {
            System.out.println("Лошадь " + getName() + " слишком устала. Нужно сил: " +
                    requiredStamina + ", имеется: " + stamina);
            return false;
        }

        stamina -= requiredStamina;
        System.out.println("Лошадь " + getName() + " проскакала " + distance +
                " км по " + terrain.getDescription() + ". Потрачено сил: " +
                requiredStamina + ". Осталось сил: " + stamina);
        return true;
    }

    @Override
    public String getStatus() {
        return "Лошадь " + getName() + ", силы: " + stamina + "/" + maxStamina;
    }
}
