package org.kirill.service;

import org.kirill.dao.BookDao;
import org.kirill.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        return bookDao.getBook();
    }

    @Override
    @Transactional
    public void save(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    @Transactional
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    @Transactional
    public void update(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void delete(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    @Transactional
    public void release(Book book) {
        bookDao.releaseBook(book);
    }
}
