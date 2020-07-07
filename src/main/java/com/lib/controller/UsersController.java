package com.lib.controller;

import com.lib.bean.Book;
import com.lib.bean.BookBorrowing;
import com.lib.bean.User;
import com.lib.service.BookService;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 作者：         王大可
 * 创建日期：     2020/6/27 20:44
 * 说明：
 **/
@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    /**
     * 查询全部用户
     */
    @RequestMapping("/user_List")
    public String member_list(Model model) {
        try {
            List<User> list = userService.findUser();
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "user_List";
    }

    /**
     * 登陆验证，用户名密码核对在sql已经做了
     */
    @RequestMapping("/checklogin")
    public String checklogin(@RequestParam String username,
                             @RequestParam String password,
                             Model model) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            model.addAttribute(user);
            if (user.getState().equals("已停用")) {
                return "fail_login";
            } else {
                return "index";
            }

        }
        return "login";
    }

    /**
     * 添加用户
     */
    @ResponseBody
    @RequestMapping("/user_Insert")
    public String user_Insert(@ModelAttribute(value = "user") User user) {
        try {
            user.setState("已启用");//设置默认帐号状态
            user.setPower("读者");//设置默认用户类型
            // System.out.println(user);
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "注册成功，请返回并登录";
    }

    /**
     * 管理员渠道 添加用户
     */
    @ResponseBody
    @RequestMapping("/user_Insert2")
    public String user_Insert2(@ModelAttribute(value = "user") User user) {
        try {
            System.out.println(user);
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "新" + user.getPower() + "账号：" + user.getUsername() + "注册成功！";
    }

    /**
     * 修改密码1：用户确认
     */
    @RequestMapping("/user_Find")
    public String user_Find(@ModelAttribute(value = "user") User user,
                            Model model) {
        user = userService.getUserByUsername(user.getUsername());
        //如果不成功获得用户就跳转到失败页面
        if (user == null) {
            return "user_Null";
        }
        model.addAttribute("user", user);
        //如果成功获得用户则跳转到修改密码页面
        return "user_Forget2";
    }

    /**
     * 修改密码2：重置密码
     */
    @ResponseBody
    @RequestMapping("/user_Forget3")
    public String user_Modify(@ModelAttribute(value = "user") User user
    ) {
        //传入的电话
        String telephone = user.getTelephone();
        //传入的密码
        String password = user.getPassword();
        //通过username获得原user对象，从而得到正确的号码
        user = userService.getUserByUsername(user.getUsername());
        if (!telephone.equals(user.getTelephone())) {
            //号码错误则返回失败页面
            return "手机号输入错误，请重新尝试";
        } else {
            //号码正确则返回成功页面
            userService.changePassword(password, user.getUsername());
            return "修改密码成功，请重新登录";
        }
    }

    /**
     * 借阅图书功能，获得图书bid，跳转到读者帐号确认
     *
     * @param bid
     * @return
     */
    @RequestMapping("/book_Borrowing")
    public String book_Borrowing(@RequestParam Integer bid,
                                 Model model) {
        User user = new User();
        model.addAttribute("bid", bid);
        model.addAttribute("user", user);
        return "book_Borrowing";
    }

    /**
     * 借阅图书2，页面获取读者，bid，进行借阅操作
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/book_Borrowing2")
    public String book_Borrowing2(@ModelAttribute(value = "user") User user,
                                  @RequestParam Integer bid,
                                  Model model) {
        user = userService.getUserByUsername(user.getUsername());
        if (user == null) {
            return "读者账号验证错误，请重试";
        }
        Book book = bookService.getBookById(bid);
        BookBorrowing bookBorrowing = new BookBorrowing(user, book);
        bookService.borrowBook(bookBorrowing);
        model.addAttribute("bookBorrowing", bookBorrowing);

        return "借阅成功，请在个人首页查看";

    }

    /**
     * 密码修改完毕跳转回登录界面
     */
    @RequestMapping("/password_Change2")
    public String password_Change2(@ModelAttribute("user") User user) {
        userService.changePasswordByUid(user.getPassword(), user.getUid(), user.getName());
        return "login";
    }
}
