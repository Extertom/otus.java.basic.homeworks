package ru.otus.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.Map;

class PersonDataBase {
    private final Map<Long, Person> persons = new HashMap<>();

    public Person findById(Long id) {
        return persons.get(id);
    }

    public void add(Person person) {
        persons.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        Person p = persons.get(person.getId());
        return p != null && isManagerPosition(p.getPosition());
    }

    public boolean isEmployee(Long id) {
        Person p = persons.get(id);
        return p != null && !isManagerPosition(p.getPosition());
    }

    private boolean isManagerPosition(Position pos) {
        return pos == Position.MANAGER ||
                pos == Position.DIRECTOR ||
                pos == Position.BRANCH_DIRECTOR ||
                pos == Position.SENIOR_MANAGER;
    }
}
