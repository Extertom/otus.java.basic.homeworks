package ru.otus.java.basic.homeworks.homework13;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalculatorSimple {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("server")) {
            startServer();
        } else {
            startClient();
        }
    }

    private static void startServer() {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Сервер запущен...");
            Socket client = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Калькулятор: + - * / (формат: a + b)");
            String input;
            while ((input = in.readLine()) != null) {
                try {
                    String[] parts = input.split(" ");
                    double a = Double.parseDouble(parts[0]);
                    double b = Double.parseDouble(parts[2]);
                    String op = parts[1];
                    double result = switch (op) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> a / b;
                        default -> throw new IllegalArgumentException();
                    };
                    out.println(a + " " + op + " " + b + " = " + result);
                } catch (Exception e) {
                    out.println("Ошибка! Используйте формат: число операция число");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startClient() {
        try (Socket socket = new Socket("localhost", 12345);
             Scanner scanner = new Scanner(System.in);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println(in.readLine());
            while (true) {
                System.out.print("Введите выражение: ");
                String expr = scanner.nextLine();
                if (expr.equals("exit")) break;
                out.println(expr);
                System.out.println("Результат: " + in.readLine());
            }
        } catch (IOException e) {
            System.out.println("Сервер не доступен");
        }
    }
}