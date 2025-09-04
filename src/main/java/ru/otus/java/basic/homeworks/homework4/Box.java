package ru.otus.java.basic.homeworks.homework4;

public class Box {
    private final double width;
    private final double height;
    private final double depth;
    private String color;
    private boolean isOpen;
    private String item;

    public Box(double width, double height, double depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
        this.isOpen = false;
        this.item = null;
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка уже открыта");
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Коробка закрыта");
        } else {
            System.out.println("Коробка уже закрыта");
        }
    }

    public void repaint(String newColor) {
        this.color = newColor;
        System.out.println("Коробка перекрашена в цвет: " + newColor);
    }

    public void addItem(String item) {
        if (!isOpen) {
            System.out.println("Нельзя положить предмет - коробка закрыта!");
            return;
        }

        if (this.item != null) {
            System.out.println("В коробке уже есть предмет: " + this.item);
        } else {
            this.item = item;
            System.out.println("Предмет '" + item + "' положен в коробку");
        }
    }

    public void removeItem() {
        if (!isOpen) {
            System.out.println("Нельзя вынуть предмет - коробка закрыта!");
            return;
        }

        if (item != null) {
            System.out.println("Предмет '" + item + "' вынут из коробки");
            item = null;
        } else {
            System.out.println("В коробке нет предметов");
        }
    }

    public void printInfo() {
        System.out.println("=== Информация о коробке ===");
        System.out.println("Размеры: " + width + "x" + height + "x" + depth);
        System.out.println("Цвет: " + color);
        System.out.println("Состояние: " + (isOpen ? "открыта" : "закрыта"));
        System.out.println("Предмет внутри: " + (item != null ? item : "отсутствует"));
        System.out.println("===========================");
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public String getColor() {
        return color;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getItem() {
        return item;
    }
}
