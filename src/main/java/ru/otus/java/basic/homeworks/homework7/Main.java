package ru.otus.java.basic.homeworks.homework7;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Иван");
        Car car = new Car("Жигули", 50.0, 0.1);
        Horse horse = new Horse("Буцефал", 100, 150);
        Bicycle bicycle = new Bicycle("Горный", 80, 420);
        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle("Вездеход-1", 70.0, 0.15);

        human.printStatus();
        human.move(5, TerrainType.PLAIN);

        System.out.println("\n============Используем машину==========");
        human.mount(car);
        human.printStatus();

        human.move(100, TerrainType.PLAIN);
        human.move(50, TerrainType.DENSE_FOREST);
        human.move(200, TerrainType.PLAIN);

        car.refuel(30);
        human.dismount();

        System.out.println("\n===============Используем лошадь===================");
        human.mount(horse);
        human.move(1, TerrainType.DENSE_FOREST);
        human.move(3, TerrainType.SWAMP);
        human.printStatus();
        horse.rest();
        human.dismount();

        System.out.println("\n=============Используем велосипед==============");
        human.mount(bicycle);
        human.move(5, TerrainType.PLAIN);
        human.move(3, TerrainType.DENSE_FOREST);
        human.printStatus();
        bicycle.rest();
        human.dismount();

        System.out.println("\n==============Используем вездеход=================");
        human.mount(allTerrainVehicle);
        human.move(50, TerrainType.PLAIN);
        human.move(30, TerrainType.DENSE_FOREST);
        human.move(20, TerrainType.SWAMP);
        human.printStatus();
        allTerrainVehicle.refuel(20.25);
        human.printStatus();
    }
}
