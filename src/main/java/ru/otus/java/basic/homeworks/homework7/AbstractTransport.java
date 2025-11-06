package ru.otus.java.basic.homeworks.homework7;

public abstract class AbstractTransport implements Transport {
    protected String name;

    public AbstractTransport(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
