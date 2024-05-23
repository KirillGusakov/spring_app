package org.kirill.service;

import org.kirill.dao.PersonDao;
import org.kirill.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public List<Person> getAll() {
        return personDao.getPeople();
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDao.savePerson(person);
    }

    @Override
    @Transactional
    public Person getById(int id) {
        return personDao.getById(id);
    }

    @Override
    @Transactional
    public void update(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    @Transactional
    public void delete(int id) {
        personDao.deletePerson(id);
    }
}
