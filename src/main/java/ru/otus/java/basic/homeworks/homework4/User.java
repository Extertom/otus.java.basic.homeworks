package ru.otus.java.basic.homeworks.homework4;

import java.time.Year;

public class User {
    private String lastName;
    private String name;
    private String middleName;
    private int birthYear;
    private String email;


    public User(String lastName, String name, String middleName, int birthYear, String email) {
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.email = email;

    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }


    public void printInfo() {
        System.out.println("ФИО: " + lastName + name + middleName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("email: " + email);
        System.out.println("-----------------------");
    }

}
