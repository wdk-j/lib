package com.lib.service.impl;

import com.lib.bean.User;
import com.lib.mapper.UserMapper;
import com.lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：         王大可
 * 创建日期：     2020/6/30 8:51
 * 说明：
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 列出所有用户
     *
     * @return
     */
    @Override
    public List<User> findUser() {
        return userMapper.list();
    }

    /**
     * 登陆验证
     *
     * @return
     */
    @Override
    public User loginUser(String username, String password) {
        try {
            User user = userMapper.checkUser(username, password);
            // System.out.println(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User getUserByUid(Integer uid) {
        return userMapper.selectByUid(uid);
    }

    @Override
    public void changePassword(String password, String username) {
        userMapper.updatePassword(password, username);
    }

    @Override
    public void changePasswordByUid(String password, Integer uid, String name) {
        userMapper.updatePasswordByUid(password, uid, name);
    }
}
