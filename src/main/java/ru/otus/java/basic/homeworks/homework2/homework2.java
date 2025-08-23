package ru.otus.java.basic.homeworks.homework2;

import java.util.Arrays;

public class homework2 {
    public static void main(String[] args) {
        //ДЗ 1
        //printStringMultipleTimes(3, "Hello Java");

        //ДЗ 2
        /*
        int[] numbers = {1, 6, 3, 8, 2, 10, 4};
        sumElementsGreaterFive(numbers);
        */

        //ДЗ 2 (второй вариант)
        /*
        int[] array = {6, 3, 8, 4, 9, 6};
        sumElementsGreaterFives(array);
        */

        //ДЗ 3
        //fillingEachCellNumber(3, new int[10]);

        //ДЗ 4
        /*
        int[] array = new int[10];
        increaseByTheSpecifiedNumber(2,array);
        System.out.println(Arrays.toString(array));
        */

        //ДЗ 5
        /*
        int[] array = {9, 4, 3, 7, 9, 9, 7, 5, 3, 5};
        whichHalfArrayBigger(array);
        */

        //ДЗ 1*
        /*
        int[] array1 = {4, 2, 7};
        int[] array2 = {5, 9};
        int[] array3 = {2, 8, 3, 5, 1};
        int[] result = sumArrays(array1, array2, array3);
        System.out.println("Result: " + Arrays.toString(result));
        */


    }

    public static void printStringMultipleTimes(int count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void sumElementsGreaterFive(int[] array) {
        if (array == null) {
            System.out.println("Error");
            return;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                sum += array[i];
            }
        }
        System.out.println("Сумма всех элементов,значение которых больше 5 = " + sum);
    }


    public static void sumElementsGreaterFives(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                sum += array[i];
            }
        }
        System.out.println("Sum = " + sum);

    }

    public static void fillingEachCellNumber(int count, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = count;
        }
        System.out.println(Arrays.toString(array));

    }

    public static void increaseByTheSpecifiedNumber(int count, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += count;
        }
    }

    public static void whichHalfArrayBigger(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            leftSum += array[i];
        }
        for (int i = array.length / 2; i < array.length; i++) {
            rightSum += array[i];
        }
        if (leftSum > rightSum) {
            System.out.println("leftSum > rightSum");
        } else {
            System.out.println("rightSum < leftSum");
        }
        System.out.println("leftSum = " + leftSum);
        System.out.println("rightSum = " + rightSum);
        System.out.println(Arrays.toString(array));

    }


    public static int[] sumArrays(int[]... arrays) {
        int maxLength = 0;
        for (int[] array : arrays) {
            if (array.length > maxLength) {
                maxLength = array.length;
            }

        }
        int[] result = new int[maxLength];
        for (int[] array : arrays) {
            for (int i = 0; i < array.length; i++) {
                result[i] += array[i];
            }

        }
        return result;
    }
}
