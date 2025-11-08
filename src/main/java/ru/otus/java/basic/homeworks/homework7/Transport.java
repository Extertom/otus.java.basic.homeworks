package ru.otus.java.basic.homeworks.homework7;

public interface Transport {
    boolean move(int distance, TerrainType terrain);

    String getStatus();

    String getName();
}
