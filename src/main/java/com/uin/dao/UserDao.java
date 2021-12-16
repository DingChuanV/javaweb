package com.uin.dao;

import com.uin.entity.User;
import com.uin.entity.UserCriteria;

import java.util.List;

/**
 *
 */
public interface UserDao {


    List<User> queryUsers(String sql, UserCriteria criteria, Object[] objects);

    boolean addUser(String sql, User user);

    boolean deleteUserById(String sql, int id);

    boolean updateUser(String sql, User user);

    User queryUserById(String sql, int id);

    User login(String sql,String username, String password);

    int countNews(String sql, UserCriteria criteria, Object[] params);
}
