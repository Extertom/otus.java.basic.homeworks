package ru.otus.java.basic.homeworks.homework8;

public class Main {
    static int sumArray(String[][] a) throws AppArraySizeException, AppArrayDataException {
        if (a.length != 4) throw new AppArraySizeException("Не 4 строки");
        for (String[] row : a) if (row.length != 4) throw new AppArraySizeException("Не 4 столбца");

        int sum = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                try {
                    sum += Integer.parseInt(a[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j, a[i][j]);
                }
        return sum;
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма: " + sumArray(arr));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
