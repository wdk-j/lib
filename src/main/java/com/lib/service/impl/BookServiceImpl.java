package com.lib.service.impl;

import com.lib.bean.Book;
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


    /**
     * 查询所有书
     */
    @Override
    public List<Book> findBookAll() {
        return bookMapper.list();
    }

    @Override
    public void addBook(Book book) {
        bookMapper.insertBook(book);
    }

    /**
     * 编辑书籍 通过bid获取
     *
     * @param id
     * @return
     */
    @Override
    public Book getBookById(Integer id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public void updateBookById(Book book, Integer id) {
        bookMapper.updateBookById(book, id);
    }


}
