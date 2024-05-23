package org.kirill.service;

import org.kirill.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    void save(Person person);

    Person getById(int id);

    void update(Person person);

    void delete(int id);
}
