package ru.otus.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.Map;

class PersonDataBase {
    private final Map<Long, Person> idMap = new HashMap<>();
    private final Map<Long, Boolean> managerCache = new HashMap<>();

    public Person findById(Long id) {
        return idMap.get(id);
    }

    public void add(Person person) {
        if (person == null || person.getId() == null) return;

        idMap.put(person.getId(), person);
        managerCache.put(person.getId(), isManagerPosition(person.getPosition()));
    }

    public boolean isManager(Person person) {
        if (person == null || person.getId() == null) return false;
        Boolean result = managerCache.get(person.getId());
        return result != null && result;
    }

    public boolean isEmployee(Long id) {
        if (id == null) return false;
        Boolean result = managerCache.get(id);
        return result != null && !result;
    }

    private boolean isManagerPosition(Position pos) {
        return pos == Position.MANAGER ||
                pos == Position.DIRECTOR ||
                pos == Position.BRANCH_DIRECTOR ||
                pos == Position.SENIOR_MANAGER;
    }
}
