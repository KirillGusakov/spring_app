package org.kirill.service;

import org.kirill.dao.BookDao;
import org.kirill.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getBook();
    }

    @Override
    public void save(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public void update(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void delete(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void release(Book book) {
        bookDao.releaseBook(book);
    }
}
