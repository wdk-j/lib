package com.lib.controller;

import com.lib.bean.Book;
import com.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 作者：         王大可
 * 创建日期：     2020/7/1 16:55
 * 说明：
 **/
@Controller
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 查询全部图书
     */
    @RequestMapping("/book_List")
    public String order_list(Model model) {
        try {
            List<Book> list = bookService.findBookAll();
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "book_List";
    }

    /**
     * 查询全部图书
     */
    @RequestMapping("/book_Manage")
    public String book_manage(Model model) {
        try {
            List<Book> list = bookService.findBookAll();
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "book_Manage";
    }

    /**
     * 编辑图书
     */
    @RequestMapping("/book_Edit")
    public String book_Edit(@RequestParam Integer id,
                            Model model) {
        try {
            Book book = bookService.getBookById(id);
            model.addAttribute("book", book);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "book_Edit";
    }

    /**
     * 修改图书信息
     */
    @Transactional
    @RequestMapping("/book_update")
    public String book_update(@ModelAttribute(value = "book") Book book,
                              @RequestParam Integer id,
                              Model model) {
        try {
            bookService.updateBookById(book, id);
            List<Book> list = bookService.findBookAll();
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "book_Manage";
    }

    /**
     * 添加书籍
     */
    @Transactional
    @RequestMapping("/book_Insert")
    public String book_Add(@ModelAttribute(value = "book") Book book,
                           Model model) {
        book.setBnumber(book.getBinnumber());
        try {
            bookService.addBook(book);
            List<Book> list = bookService.findBookAll();
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success_Add";
    }

}
