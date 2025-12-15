package ru.otus.java.basic.homeworks.homework12;

import java.io.*;
import java.util.*;

public class FileManagerIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Текстовые файлы в директории на текущий момент: ");
            File currentDir = new File(".");
            String[] files = currentDir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });

            if (files == null || files.length == 0) {
                System.out.println("Файлов не найдено.");
            } else {
                for (int i = 0; i < files.length; i++) {
                    System.out.println((i + 1) + ". " + files[i]);
                }
            }

            System.out.print("\nВведите имя файла: ");
            String fileName = scanner.nextLine();
            if (!fileName.endsWith(".txt")) {
                fileName += ".txt";
            }
            File file = new File(fileName);

            if (file.exists() && file.isFile()) {
                System.out.println("\nСодержимое файла:");
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
            System.out.println("\nВводите текст для записи (чтобы выйти введите 'exit'):");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        break;
                    }
                    writer.write(input);
                    writer.newLine();
                    writer.flush();
                }
            }
            System.out.println("Данные сохранены в " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
