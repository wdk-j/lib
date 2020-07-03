package com.lib.controller;

import com.lib.bean.Book;
import com.lib.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * 作者：         王大可
 * 创建日期：     2020/6/27 17:15
 * 说明：
 **/
@Controller
public class PageController {


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
                          Model model) {
        // System.out.println(name+" "+power);
        model.addAttribute("name", name);
        model.addAttribute("power", power);
        model.addAttribute("date", new Date());
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
     * /order-list订单列表1
     */
    @RequestMapping("/order-list1")
    public String order_list1() {
        return "order-list1";
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
     * 添加成功页面
     */
    @RequestMapping("/success_Add")
    public String success_Add() {
        return "success_Add";
    }

    /**
     * 注册成功页面
     */
    @RequestMapping("/success_Sign")
    public String success_Sign() {
        return "success_Sign";
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


}
