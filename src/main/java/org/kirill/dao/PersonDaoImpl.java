package org.kirill.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kirill.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao{


    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> getPeople() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createSelectionQuery("FROM Person", Person.class).getResultList();
    }

    @Override
    public void savePerson(Person person) {
       Session currentSession = sessionFactory.getCurrentSession();
       currentSession.persist(person);
    }

    @Override
    public Person getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Person.class, id);
    }

    @Override
    public void updatePerson(Person person) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createMutationQuery("UPDATE Person SET fio = :fio, date = :date WHERE id = :id")
                .setParameter("fio", person.getFio())
                .setParameter("date", person.getDate())
                .setParameter("id", person.getId())
                .executeUpdate();

    }

    @Override
    public void deletePerson(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createMutationQuery("DELETE FROM Person WHERE id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
