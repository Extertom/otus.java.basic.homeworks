package ru.otus.java.basic.homeworks.homework3;

public class homework3 {
    public static void main(String[] args) {

        int[][] array = {
                {1, -2, 3},
                {-4, 5, -6},
                {7, 8, -9}
        };
        int result = sumOfPositiveElements(array);
        System.out.println();
        System.out.println("Сумма положительных элементов: " + result);


        System.out.println("\nПолый квадрат 5x5:");
        printHollowSquare(5);
        System.out.println();


        int[][] array0 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Исходный массив 3x3:");
        printArray(array0);
        zeroDiagonal(array0);
        System.out.println();
        System.out.println("Поставил 0 по диагоналям:");
        printArray(array0);


        int[][] testArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int max = findMax(testArray);
        System.out.println();
        System.out.println("Максимальный элемент: " + max);
        int[][] negativeArray = {
                {-5, -2, -10},
                {-1, -8, -3}
        };
        System.out.println();
        System.out.println("Максимальный элемент: " + findMax(negativeArray));


        int[][] array1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println();
        System.out.println("Сумма второй строки: " + calculateSecondRowSum(array1));
        int[][] array2 = {
                {1, 2, 3}
        };
        System.out.println();
        System.out.println("Сумма второй строки: " + calculateSecondRowSum(array2));

    }

    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public static void printHollowSquare(int size) {
        if (size <= 0) {
            System.out.println("Размер должен быть положительным числом");
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void zeroDiagonal(int[][] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int rows = array.length;
        for (int i = 0; i < rows; i++) {
            if (array[i] != null) {
                int cols = array[i].length;
                if (i < cols) {
                    array[i][i] = 0;
                }
                int secondaryIndex = cols - 1 - i;
                if (secondaryIndex >= 0 && secondaryIndex < cols && secondaryIndex != i) {
                    array[i][secondaryIndex] = 0;
                }
            }
        }
    }

    public static void printArray(int[][] array) {
        if (array == null) {
            System.out.println("Массив: null");
            return;
        }
        for (int[] row : array) {
            if (row != null) {
                for (int element : row) {
                    System.out.printf("%3d", element);
                }
                System.out.println();
            } else {
                System.out.println("null");
            }
        }
    }

    public static int findMax(int[][] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new IllegalArgumentException("Строка массива не может быть null");
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int calculateSecondRowSum(int[][] array) {
        if (array == null || array.length < 2) {
            return -1;
        }
        if (array[1] == null) {
            return -1;
        }
        int sum = 0;
        for (int j = 0; j < array[1].length; j++) {
            sum += array[1][j];
        }
        return sum;
    }
}
