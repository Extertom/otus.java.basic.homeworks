package ru.otus.java.basic.homeworks.homework7;

public class Bicycle extends AbstractTransport {
    private Human rider;

    public Bicycle(String name) {
        super(name);
        this.rider = null;
    }


    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (rider == null) {
            System.out.println("✗ На велосипеде '" + getName() + "' нет всадника!");
            return false;
        }
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Велосипед " + getName() + " не может перемещаться по " + terrain.getDescription());
            return false;
        }
        int baseConsumption = 2;
        int consumptionMultiplier = (terrain == TerrainType.DENSE_FOREST) ? 2 : 1;
        int requiredStamina = distance * baseConsumption * consumptionMultiplier;

        if (!rider.consumeStamina(requiredStamina)) {
            System.out.println(rider.getName() + " слишком устал(а) для поездки. Нужно сил: " +
                    requiredStamina + ", имеется: " + rider.getStamina());
            return false;
        }

        System.out.println("Велосипед " + getName() + " с " + rider.getName() +
                " проехал " + distance + " км по " + terrain.getDescription() +
                ". Потрачено сил: " + requiredStamina +
                ". Осталось сил: " + rider.getStamina() + "/" + rider.getMaxStamina());
        return true;
    }

    @Override
    public String getStatus() {
        if (rider == null) {
            return "Велосипед " + getName() + ", без всадника";
        } else {
            return "Велосипед " + getName() + ", всадник: " + rider.getName() +
                    ", выносливость: " + rider.getStamina() + "/" + rider.getMaxStamina();
        }
    }
    public void setRider(Human human) {
        this.rider = human;
    }

    public void removeRider() {
        this.rider = null;
    }
}
