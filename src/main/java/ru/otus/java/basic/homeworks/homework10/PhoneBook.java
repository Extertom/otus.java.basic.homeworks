package ru.otus.java.basic.homeworks.homework10;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        contacts.putIfAbsent(name, new HashSet<>());
        contacts.get(name).add(phoneNumber);
    }

    public List<String> find(String name) {
        Set<String> phones = contacts.get(name);
        return phones != null ? new ArrayList<>(phones) : new ArrayList<>();
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (Set<String> phones : contacts.values()) {
            if (phones.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
