package ru.otus.java.basic.homeworks.homework4;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[10];
        users[0] = new User("Иванов ", "Иван ", "Иванович", 1978, "IvanovIv@mail.ru");
        users[1] = new User("Петров ", "Петр ", "Петрович", 1990, "Petrovich@mail.ru");
        users[2] = new User("Тимофеева ", "Марина ", "Константиновна", 1980, "Timofeeva@mail.ru");
        users[3] = new User("Федоров ", "Михаил ", "Александрович", 1965, "Fedorov@mail.ru");
        users[4] = new User("Ходырев ", "Александр ", "Валерьевич", 1995, "Hodirev@mail.ru");
        users[5] = new User("Григорян ", "Марк ", "Степанович", 1970, "Stepanovich@mail.ru");
        users[6] = new User("Говорущенко ", "Валерия ", "Михаиловна", 1987, "Govorushenko@mail.ru");
        users[7] = new User("Марунчак ", "Дмитрий ", "Дмитриевич", 1960, "Marunchak@mail.ru");
        users[8] = new User("Анисимов ", "Максим ", "Константинович", 1992, "Anisimov@mail.ru");
        users[9] = new User("Константинов ", "Андрей ", "Иванович", 1978, "Konstantinov@mail.ru");

        System.out.println("=== ПОЛЬЗОВАТЕЛИ СТАРШЕ 40 ЛЕТ ===");
        int currentYear = Year.now().getValue();
        for (User user : users) {
            int age = currentYear - user.getBirthYear();
            if (age > 40) {
                user.printInfo();
            }

        }

        System.out.println("\n=== ДЕМОНСТРАЦИЯ РАБОТЫ С КОРОБКОЙ ===");

        Box box = new Box(10.5, 5.2, 7.8, "красный");
        box.printInfo();

        box.open();
        box.addItem("книга");
        box.addItem("тетрадь"); // Не получится - уже есть предмет
        box.printInfo();

        box.removeItem();
        box.addItem("ручка");
        box.close();
        box.addItem("карандаш"); // Не получится - коробка закрыта
        box.printInfo();

        box.repaint("синий");
        box.open();
        box.removeItem();
        box.printInfo();
    }
}





