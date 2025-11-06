package ru.otus.java.basic.homeworks.homework7;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Иван");
        Transport car = new Car("Жигули", 50.0, 0.1);
        Transport horse = new Horse("Буцефал", 100, 3);
        Transport bicycle = new Bicycle("Горный", 80, 2);
        Transport atv = new AllTerrainVehicle("Вездеход-1", 70.0, 0.15);

        Transport[] transports = {car, horse, bicycle, atv};
        for (Transport transport : transports) {
            System.out.println("\n--- " + transport.getName() + " ---");
            human.mount(transport);

            boolean plainResult = human.move(10, TerrainType.PLAIN);
            boolean forestResult = human.move(10, TerrainType.DENSE_FOREST);
            boolean swampResult = human.move(10, TerrainType.SWAMP);

            System.out.println("Результаты для " + transport.getName() + ":");
            System.out.println(" - Равнина: " + (plainResult ? "Выполнено" : "Неудачно"));
            System.out.println(" - Лес: " + (forestResult ? "Выполнено" : "Неудачно"));
            System.out.println(" - Болото: " + (swampResult ? "Выполнено" : "Неудачно"));

            human.dismount();

        }
    }
}
