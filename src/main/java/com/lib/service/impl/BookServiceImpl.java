package com.lib.service.impl;

import com.lib.bean.Book;
import com.lib.bean.BookBorrowing;
import com.lib.bean.BookHistory;
import com.lib.mapper.BookMapper;
import com.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：         王大可
 * 创建日期：     2020/6/27 20:00
 * 说明：
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> findBookAll() {
        return bookMapper.list();
    }

    @Override
    public void addBook(Book book) {
        bookMapper.insertBook(book);
    }


    @Override
    public Book getBookById(Integer id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public void updateBookById(Book book, Integer id) {
        bookMapper.updateBookById(book, id);
    }

    @Override
    public void borrowBook(BookBorrowing bookBorrowing) {
        bookMapper.insertBorrowingBook(bookBorrowing);
    }

    @Override
    public List<BookBorrowing> findBookByUsername(String username) {
        return bookMapper.selectBookByUsername(username);
    }

    @Override
    public List<BookBorrowing> findBook_BorrowingAll() {
        return bookMapper.selectAllBookBorrowing();
    }

    @Override
    public BookBorrowing findBook_BorrowingByNumber(Integer number) {
        return bookMapper.selectBookBorrowingByNumber(number);
    }

    @Override
    public void reBookByNumber(Integer number) {
        bookMapper.deleteBookBorrowingByNumber(number);
    }

    @Override
    public void addBookHistory(BookHistory bookHistory) {
        bookMapper.insertBookHistory(bookHistory);
    }

    @Override
    public List<BookHistory> findBook_HistoryByUsername(String username) {
        return bookMapper.selectBookHistoryByUsername(username);
    }

    @Override
    public List<BookHistory> findBook_HistoryAll() {
        return bookMapper.selectBookHistoryAll();
    }

    @Override
    public void fine_PayByNumber(Double fine, Integer number) {
        bookMapper.updateFineById(fine, number);
    }

    @Override
    public BookHistory findBook_HistoryByNumber(Integer number) {
        return bookMapper.selectBookHistoryByNumber(number);
    }
}
