package ru.otus.java.basic.homeworks.homework10;

public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add("Иванов Иван", "111-111");
        book.add("Иванов Иван", "222-222");
        book.add("Петров Петр", "333-333");

        System.out.println(book.find("Иванов Иван"));
        System.out.println(book.find("Неизвестный"));

        System.out.println(book.containsPhoneNumber("111-111"));
        System.out.println(book.containsPhoneNumber("999-999"));
    }
}
