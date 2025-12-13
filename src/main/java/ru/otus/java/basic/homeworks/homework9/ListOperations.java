package ru.otus.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {
    public static void main(String[] args) {
        System.out.println(createSequence(3, 7));

        List<Integer> numbers = new ArrayList<>(List.of(2, 6, 8, 3, 10));
        System.out.println(sumGreaterThanFive(numbers));

        List<Integer> testList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        replaceAllElements(testList, 9);
        System.out.println(testList);

        increaseAllElements(testList, 1);
        System.out.println(testList);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иван", 25));
        employees.add(new Employee("Мария", 30));
        employees.add(new Employee("Петр", 22));
        employees.add(new Employee("Анна", 35));
        employees.add(new Employee("Сергей", 28));

        System.out.println(getEmployeeNames(employees));

        System.out.println(filterEmployeesByAge(employees, 27));

        System.out.println(isAverageAgeAbove(employees, 28));

        System.out.println(getYoungestEmployee(employees));
    }

    public static List<Integer> createSequence(int min, int max) {
        List<Integer> sequence = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            sequence.add(i);
        }
        return sequence;
    }

    public static int sumGreaterThanFive(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            if (num > 5) {
                sum += num;
            }
        }
        return sum;
    }

    public static void replaceAllElements(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    public static void increaseAllElements(List<Integer> list, int increment) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + increment);
        }
    }

    public static List<String> getEmployeeNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (Employee emp : employees) {
            names.add(emp.getName());
        }
        return names;
    }

    public static List<Employee> filterEmployeesByAge(List<Employee> employees, int minAge) {
        List<Employee> filtered = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getAge() >= minAge) {
                filtered.add(emp);
            }
        }
        return filtered;
    }

    public static boolean isAverageAgeAbove(List<Employee> employees, double minAverageAge) {
        if (employees.isEmpty()) return false;
        int total = 0;
        for (Employee emp : employees) {
            total += emp.getAge();
        }
        return (double) total / employees.size() > minAverageAge;
    }

    public static Employee getYoungestEmployee(List<Employee> employees) {
        if (employees.isEmpty()) return null;
        Employee youngest = employees.getFirst();
        for (Employee emp : employees) {
            if (emp.getAge() < youngest.getAge()) {
                youngest = emp;
            }
        }
        return youngest;
    }
}

