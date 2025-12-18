package ru.otus.java.basic.homeworks.homework11;

public class Main {
    public static void main(String[] args) {
        PersonDataBase db = new PersonDataBase();

        Person p1 = new Person("Иван", Position.MANAGER, 1L);
        Person p2 = new Person("Петр", Position.DEVELOPER, 2L);
        Person p3 = new Person("Анна", Position.DIRECTOR, 3L);

        db.add(p1);
        db.add(p2);
        db.add(p3);

        System.out.println("Найден ID 2: " + (db.findById(2L) != null));
        System.out.println("p1 менеджер: " + db.isManager(p1));
        System.out.println("p2 менеджер: " + db.isManager(p2));
        System.out.println("ID 2 сотрудник: " + db.isEmployee(2L));
        System.out.println("ID 1 сотрудник: " + db.isEmployee(1L));

        int[] arr = {5, 2, 8, 1};
        bubbleSort(arr.clone());
        quickSort(arr.clone());
    }

    private static void bubbleSort(int[] arr) {
        System.out.print("Bubble до: " + java.util.Arrays.toString(arr));
        SortAlgorithms.bubbleSort(arr);
        System.out.println(", после: " + java.util.Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        System.out.print("Quick до: " + java.util.Arrays.toString(arr));
        SortAlgorithms.quickSort(arr);
        System.out.println(", после: " + java.util.Arrays.toString(arr));
    }
}
