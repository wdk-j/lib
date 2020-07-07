package com.lib.service;

import com.lib.bean.Book;
import com.lib.bean.BookBorrowing;
import com.lib.bean.BookHistory;

import java.util.List;

/**
 * Book服务层
 **/
public interface BookService {

    List<Book> findBookAll();

    void addBook(Book book);

    Book getBookById(Integer id);

    void updateBookById(Book book, Integer id);

    void borrowBook(BookBorrowing bookBorrowing);

    List<BookBorrowing> findBookByUsername(String username);

    List<BookBorrowing> findBook_BorrowingAll();

    BookBorrowing findBook_BorrowingByNumber(Integer number);

    void reBookByNumber(Integer number);

    void addBookHistory(BookHistory bookHistory);

    List<BookHistory> findBook_HistoryByUsername(String username);

    List<BookHistory> findBook_HistoryAll();

    void fine_PayByNumber(Double fine, Integer number);

    BookHistory findBook_HistoryByNumber(Integer number);
}
