package ru.otus.java.basic.homeworks.homework11;

public class Main {
    public static void main(String[] args) {
        PersonDataBase db = new PersonDataBase();

        Person manager = new Person("Иван", Position.MANAGER, 1L);
        Person developer = new Person("Петр", Position.DEVELOPER, 2L);
        Person director = new Person("Анна", Position.DIRECTOR, 3L);
        Person driver = new Person("Сидор", Position.DRIVER, 4L);

        db.add(manager);
        db.add(developer);
        db.add(director);
        db.add(driver);

        System.out.println("1. Поиск по ID:");
        System.out.println("   ID 2: " + db.findById(2L));
        System.out.println("   ID 5 (не существует): " + db.findById(5L));

        System.out.println("\n2. Проверка isManager:");
        System.out.println("   " + manager.getName() + " менеджер " + db.isManager(manager));
        System.out.println("   " + developer.getName() + " менеджер " + db.isManager(developer));
        System.out.println("   " + director.getName() + " менеджер " + db.isManager(director));

        System.out.println("\n3. Проверка isEmployee:");
        System.out.println("   ID 2 сотрудник " + db.isEmployee(2L));
        System.out.println("   ID 1 сотрудник " + db.isEmployee(1L));
        System.out.println("   ID 4 сотрудник " + db.isEmployee(4L));

        int[] arr1 = {5, 2, 8, 1, 9};
        System.out.println("4. BubbleSort:");
        System.out.print("   До: ");
        printArray(arr1);
        SortAlgorithms.bubbleSort(arr1);
        System.out.print("   После: ");
        printArray(arr1);

        int[] arr2 = {9, 3, 7, 1, 6, 2, 8};
        System.out.println("\n5. QuickSort:");
        System.out.print("   До: ");
        printArray(arr2);
        SortAlgorithms.quickSort(arr2);
        System.out.print("   После: ");
        printArray(arr2);

        System.out.println("\n6. Граничные случаи:");
        int[] empty = {};
        int[] single = {1};
        int[] sorted = {1, 2, 3, 4, 5};

        System.out.print("   Пустой массив: ");
        SortAlgorithms.bubbleSort(empty);
        printArray(empty);

        System.out.print("   Один элемент: ");
        SortAlgorithms.quickSort(single);
        printArray(single);

        System.out.print("   Уже отсортированный: ");
        SortAlgorithms.quickSort(sorted);
        printArray(sorted);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
