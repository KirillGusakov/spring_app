package org.kirill.service;

import org.kirill.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    void save(Book book);

    Book getById(int id);

    void update(Book book);
    void delete(int id);

    void release(Book book);
}
