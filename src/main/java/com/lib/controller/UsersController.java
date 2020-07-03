package com.lib.controller;

import com.lib.bean.User;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            return "index";
        }
        return "login";
    }

    /**
     * 添加用户
     */
    @RequestMapping("/user_Insert")
    public String user_Insert(@ModelAttribute(value = "user") User user) {
        try {
            user.setState("已启用");//设置默认帐号状态
            user.setPower("读者");//设置默认用户类型
            System.out.println(user);
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success_Sign";
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
            return "fail_Modify";
        } else {
            //号码正确则返回成功页面
            userService.changePassword(password, user.getUsername());
            return "success_Modify";
        }
    }
}
