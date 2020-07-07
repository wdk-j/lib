package com.lib.controller;

import com.lib.bean.Book;
import com.lib.bean.BookBorrowing;
import com.lib.bean.BookHistory;
import com.lib.bean.User;
import com.lib.service.BookService;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 作者：         王大可
 * 创建日期：     2020/6/27 17:15
 * 说明：
 **/
@Controller
public class PageController {


    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    /**
     * 页面跳转测试
     */
    @RequestMapping("/")
    public String showpage() {
        return "login";
    }

    /**
     * frame 我的桌面
     *
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(@RequestParam String name,
                          @RequestParam String power,
                          @RequestParam String username,
                          Model model) {
        List<BookBorrowing> bookBorrowings = bookService.findBookByUsername(username);
        model.addAttribute("name", name);
        model.addAttribute("power", power);
        model.addAttribute("date", new Date());
        model.addAttribute("bookBorrowings", bookBorrowings);
        return "welcome";
    }

    /**
     * 我的桌面
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }




    /**
     * 登陆跳转
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 添加书籍，返回一个book对象
     */
    @RequestMapping("/book_Add")
    public String book_Add(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book_Add";
    }

    /**
     * 读者注册/添加读者 返回一个user对象
     */
    @RequestMapping("/user_Add")
    public String member_add(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_Add";
    }

    /**
     * 读者注册/添加读者/可设置权限 返回一个user对象
     */
    @RequestMapping("/user_AddPower")
    public String member_addPower(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_AddPower";
    }

    /**
     * 添加成功页面
     */
    @RequestMapping("/success_Add")
    public String success_Add() {
        return "success_Add";
    }


    /**
     * 忘记密码的页面
     */
    @RequestMapping("/user_Forget")
    public String user_Forget(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_Forget";
    }

    /**
     * 跳转到修改密码页面
     */
    @RequestMapping("/password_Change")
    public String password_Change(@RequestParam Integer uid,
                                  Model model) {

        User user = userService.getUserByUid(uid);
        model.addAttribute("user", user);
        return "password_Change";
    }

    /**
     * 缴纳罚款
     */
    @RequestMapping("/fine_Pay")
    public String fine_Pay(@RequestParam Integer number,
                           Model model) {
        BookHistory bookHistory = bookService.findBook_HistoryByNumber(number);
        model.addAttribute("bookHistory", bookHistory);
        return "fine_Pay";
    }


}
