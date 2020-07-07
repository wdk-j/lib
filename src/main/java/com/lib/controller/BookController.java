package com.lib.controller;

import com.lib.bean.Book;
import com.lib.bean.BookBorrowing;
import com.lib.bean.BookHistory;
import com.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
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
        return "添加成功,请返回并刷新后查看";
    }

    /**
     * 查询借阅记录
     */
    @RequestMapping("/bookBorrowing_List")
    public String bookBorrowing_List(Model model) {
        List<BookBorrowing> bookBorrowings = bookService.findBook_BorrowingAll();
        model.addAttribute("bookBorrowings", bookBorrowings);
        return "bookBorrowing_List";
    }

    /**
     * 图书归还入口
     */
    @RequestMapping("/book_Return")
    public String book_Return(@RequestParam Integer number,
                              Model model) {
        BookBorrowing bookBorrowing = bookService.findBook_BorrowingByNumber(number);
        Integer fine = 0;
        model.addAttribute("fine", fine);
        model.addAttribute("bookBorrowing", bookBorrowing);
        return "book_Return";
    }

    /**
     * 图书归还确认
     */
    @Transactional
    @RequestMapping("/book_Return2")
    public String book_Return2(@RequestParam Double fine,
                               @ModelAttribute(value = "bookBorrowing") BookBorrowing bookBorrowing,
                               Model model) {
        //添加借阅历史记录
        BookHistory bookHistory = new BookHistory(bookBorrowing, fine);
        bookService.addBookHistory(bookHistory);
        //删除借阅记录
        bookService.reBookByNumber(bookBorrowing.getNumber());
        List<BookBorrowing> bookBorrowings = bookService.findBook_BorrowingAll();
        model.addAttribute("bookBorrowings", bookBorrowings);
        return "bookBorrowing_List";
    }

    /**
     * 借阅历史查询1，输入username 查询借阅历史
     */
    @RequestMapping("/book_History")
    public String book_History(Model model) {
        return "book_History";
    }


    /**
     * 借阅历史查询2，输入username 查询借阅历史
     */
    @RequestMapping("/book_History2")
    public String book_History2(@RequestParam String username,
                                Model model) {
        //获得借阅历史
        List<BookHistory> list = bookService.findBook_HistoryByUsername(username);
        model.addAttribute("list", list);
        return "bookHistory_List";
    }

    /**
     * 全部借阅历史管理
     */
    @RequestMapping("/bookHistory_ListAll")
    public String bookHistory_ListAll(Model model) {
        List<BookHistory> list = bookService.findBook_HistoryAll();
        model.addAttribute("list", list);
        return "bookHistory_ListAll";
    }

    /**
     * 罚金缴纳操作
     */
    @RequestMapping("/fine_Pay2")
    public String fine_Pay2(@ModelAttribute("bookHistory") BookHistory bookHistory,
                            Model model) {
        bookService.fine_PayByNumber(bookHistory.getFine(), bookHistory.getNumber());
        List<BookHistory> list = bookService.findBook_HistoryAll();
        model.addAttribute("list", list);
        return "bookHistory_ListAll";
    }
}
