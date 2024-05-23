package org.kirill.dao;


import org.kirill.entity.Person;

import java.util.List;

public interface PersonDao {
    List<Person> getPeople();
    void savePerson(Person person);

    Person getById(int id);

    void updatePerson(Person person);

    void deletePerson(int id);
}
