package org.kirill.dao;

import org.kirill.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBook();
    void saveBook(Book book);

    Book getById(int id);

    void updateBook(Book book);
    void deleteBook(int id);

    void releaseBook(Book book);
}
