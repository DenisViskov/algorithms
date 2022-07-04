package com.company.widthSearch;

import java.util.List;
import java.util.Objects;

public class Person {
    private final String name;

    private final List<Person> friends;

    public Person(String name, List<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return name.equals(person.name) && friends.equals(person.friends);
    }

    @Override public int hashCode() {
        return Objects.hash(name, friends);
    }
}
