package org.kirill.service;

import org.kirill.dao.PersonDao;
import org.kirill.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> getAll() {
        return personDao.getPeople();
    }

    @Override
    public void save(Person person) {
        personDao.savePerson(person);
    }

    @Override
    public Person getById(int id) {
        return personDao.getById(id);
    }

    @Override
    public void update(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void delete(int id) {
        personDao.deletePerson(id);
    }
}
