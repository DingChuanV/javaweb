package com.uin.service;

import com.uin.entity.User;
import com.uin.entity.UserCriteria;
import com.uin.util.PageHelper;

/**
 *
 */
public interface UserService {

    PageHelper<User> queryUsers(UserCriteria uc);

    boolean addUser(User user);

    boolean deleteUserById(int id);

    boolean updateUser(User user);

    User queryUserById(int id);

    User login(String username,String password);
    int countNews(UserCriteria criteria);
}
