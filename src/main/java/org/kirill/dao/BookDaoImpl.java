package org.kirill.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kirill.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class BookDaoImpl implements BookDao{
    private final SessionFactory sessionFactory;

    @Autowired
    public BookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public List<Book> getBook() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createSelectionQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    public void saveBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(book);
    }

    @Override
    public Book getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Book.class, id);
    }

    @Override
    public void updateBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createMutationQuery("UPDATE Book SET name = :name," +
                                           "author = :author, year = :year WHERE id = :id")
                .setParameter("name", book.getName())
                .setParameter("author", book.getAuthor())
                .setParameter("year", book.getYear())
                .setParameter("id", book.getId())
                .executeUpdate();
    }

    @Override
    public void deleteBook(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createMutationQuery("DELETE FROM Book WHERE id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void releaseBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(book);
    }


}
