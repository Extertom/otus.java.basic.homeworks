package ru.otus.java.basic.homeworks.homework14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwoImplementationsOfArrayFilling {
    public static void main(String[] args) {
        final int SIZE = 100_000_000;
        System.out.println("Заполнение массива из " + SIZE + " элементов\n");
        System.out.println("Однопоточное заполнение:");
        double[] array1 = new double[SIZE];
        long time1 = measureTime(() -> fillArray(array1, 0, SIZE));
        System.out.println("Время: " + time1 + " мс\n");

        System.out.println("Многопоточное заполнение (4 потока):");
        double[] array2 = new double[SIZE];
        long time2 = measureTime(() -> fillArrayMultithreaded(array2, 4));
        System.out.println("Время: " + time2 + " мс\n");
        System.out.println("Проверка корректности:");
        checkArraysEqual(array1, array2, 5);
    }

    private static void fillArray(double[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    private static void fillArrayMultithreaded(double[] array, int threadCount) {
        try (ExecutorService executor = Executors.newFixedThreadPool(threadCount)) {
            int chunkSize = array.length / threadCount;
            for (int i = 0; i < threadCount; i++) {
                final int start = i * chunkSize;
                final int end = (i == threadCount - 1) ? array.length : start + chunkSize;
                executor.execute(() -> fillArray(array, start, end));
            }
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Выполнение прервано", e);
        }
    }

    private static long measureTime(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }

    private static void checkArraysEqual(double[] arr1, double[] arr2, int checkCount) {
        boolean allMatch = true;
        for (int i = 0; i < checkCount && i < arr1.length; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > 0.000001) {
                System.out.printf("  Ошибка: значения на позиции %d отличаются%n", i);
                allMatch = false;
            }
        }
        if (allMatch) {
            System.out.println("Результаты идентичны (проверено первых " + checkCount + " значений)");
        }
    }
}
