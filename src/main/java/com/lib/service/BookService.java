package com.lib.service;

import com.lib.bean.Book;

import java.util.List;

/**
 * Book服务层
 **/
public interface BookService {

    List<Book> findBookAll();

    void addBook(Book book);

    Book getBookById(Integer id);

    void updateBookById(Book book, Integer id);
}
