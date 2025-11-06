package ru.otus.java.basic.homeworks.homework7;

public enum TerrainType {
    DENSE_FOREST("густому лесу"),
    PLAIN("равнине"),
    SWAMP("болоту");
    private final String description;

    TerrainType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
