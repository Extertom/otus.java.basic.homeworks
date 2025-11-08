package ru.otus.java.basic.homeworks.homework7;

public class Human {
    private final String name;
    private Transport currentTransport;
    private int stamina;
    private final int maxStamina;

    public Human(String name, int maxStamina) {
        this.name = name;
        this.maxStamina = maxStamina;
        this.stamina = maxStamina;
        this.currentTransport = null;
    }


    public boolean move(int distance, TerrainType terrain) {
        System.out.println("\n--- " + name + " пытается переместиться на " + distance + " км по " + terrain.getDescription() + " ---");

        if (currentTransport == null) {
            System.out.println(name + " прошел " + distance + " км пешком по " + terrain.getDescription());
            return true;
        }
        boolean success = currentTransport.move(distance, terrain);
        System.out.println(name + (success ? " успешно переместился на " : " не смог переместиться на ") + currentTransport.getName());
        return success;
    }


    public void mount(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже использует " + currentTransport.getName());
            return;
        }
        this.currentTransport = transport;
        if (transport instanceof Bicycle bicycle) {
            bicycle.setRider(this);
        }
        System.out.println(name + " сел на " + transport.getName());
    }

    public void dismount() {
        if (currentTransport == null) {
            System.out.println(name + " и так не использует транспорт");
            return;
        }
        if (currentTransport instanceof Bicycle bicycle) {
            bicycle.removeRider();
        }

        System.out.println(name + " сошел с " + currentTransport.getName());
        currentTransport = null;
    }

    public boolean consumeStamina(int amount) {
        if (stamina < amount) {
            return false;
        }
        stamina -= amount;
        return true;
    }


    public String getName() {
        return name;
    }


    public int getStamina() {
        return stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

}
