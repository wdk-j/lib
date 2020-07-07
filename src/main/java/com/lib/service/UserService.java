package com.lib.service;

import com.lib.bean.User;

import java.util.List;

/**
 * 作者：         王大可
 * 创建日期：     2020/6/30 8:51
 * 说明：
 **/
public interface UserService {

    List<User> findUser();

    User loginUser(String username, String password);

    void addUser(User user);

    User getUserByUsername(String username);

    User getUserByUid(Integer uid);

    void changePassword(String password, String username);

    void changePasswordByUid(String password, Integer uid, String name);
}
