package com.lib.mapper;

import com.lib.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * User持久层
 **/
public interface UserMapper {

    @Select("select * from user")
    List<User> list();

    @Select("select * from user where username = #{username} and password = #{password}")
    User checkUser(String username, String password);

    @Insert("insert into user(username,password,name,sex,telephone,state,power)" +
            "values(#{username},#{password},#{name},#{sex},#{telephone},#{state},#{power})")
    void insertUser(User user);

    @Select("select * from user where username=#{username}")
    User selectByUsername(String username);

    @Update("update user set password=#{password} where username=#{username}")
    void updatePassword(String password, String username);
}
