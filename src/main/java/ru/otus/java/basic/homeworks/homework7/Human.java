package ru.otus.java.basic.homeworks.homework7;

public class Human {
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.currentTransport = null;
    }

    public void mount(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже использует " + currentTransport.getName());
            return;
        }
        this.currentTransport = transport;
        System.out.println(name + " сел на " + transport.getName());
    }

    public void dismount() {
        if (currentTransport == null) {
            System.out.println(name + " и так не использует транспорт");
            return;
        }
        System.out.println(name + " сошел с " + currentTransport.getName());
        currentTransport = null;
    }

    public void move(int distance, TerrainType terrain) {
        System.out.println("\n--- " + name + " пытается переместиться на " + distance + "км. по " + terrain.getDescription() + " ---");
        if (currentTransport == null) {
            System.out.println(name + " прошел " + distance + " км.пешком по  " + terrain.getDescription());

        } else {
            boolean success = currentTransport.move(distance, terrain);
            if (success) {
                System.out.println(name + " успешно переместился на " + currentTransport.getName());
            } else {
                System.out.println(name + " не смог переместиться на " + currentTransport.getName());
            }
        }
    }

    public void printStatus() {
        System.out.println("\n--- Статус " + name + " ---");
        if (currentTransport == null) {
            System.out.println("Пешком, без транспорта");
        } else {
            System.out.println("На транспорте: " + currentTransport.getStatus());
        }
    }
}
