package ru.otus.java.basic.homeworks.homework7;

public abstract class Transport {
    protected String name;

    public Transport(String name) {
        this.name = name;
    }

    public abstract boolean move(int distance, TerrainType terrain);

    public abstract String getStatus();

    public String getName() {
        return name;
    }
}
