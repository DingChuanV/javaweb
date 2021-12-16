package com.uin.service.impl;

import com.uin.dao.UserDao;
import com.uin.dao.impl.UserDaoImpl;
import com.uin.entity.*;
import com.uin.entity.UserCriteria;
import com.uin.service.UserService;
import com.uin.util.PageHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public PageHelper<User> queryUsers(UserCriteria  criteria){
        String sql = "select * from news_user ";
        
        List<Object> params = new ArrayList<>();
        sql += constrcriteriatWhereClause(criteria,params);

        //分页语句
        sql += " limit ?,?";

        PageHelper<User> pageHelper = new PageHelper<>();

        //分页查询的信息
        List<User> newsList = userDao.queryUsers(sql, criteria,params.toArray());

        //条件查询的总数
        int totalCount = countNews(criteria);
        pageHelper.setTotalCount(totalCount);
        pageHelper.setPageSize(criteria.getPageSize());
        pageHelper.setCurrentPage(criteria.getCurrentPage());
        pageHelper.setData(newsList);

        return pageHelper;
    }
    @Override
    public int countNews(UserCriteria criteria) {
        List<Object> params = new ArrayList<>();
        //得到sql语句
        String sql = "select count(1) from news_user " + constrcriteriatWhereClause(criteria,params);

        return userDao.countNews(sql, criteria,params.toArray());
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into news_user(`username`,`password`,`email`,`usertype`) values(?,?,?,?)";
        return userDao.addUser(sql, user);
    }

    @Override
    public boolean deleteUserById(int id) {
        String sql = "delete from news_user where id = ?";
        return userDao.deleteUserById(sql, id);
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update news_user set username = ?, password = ? , email = ? , usertype = ? where id = ?";
        return userDao.updateUser(sql, user);
    }

    @Override
    public User queryUserById(int id) {
        String sql = "select * from news_user where id = ?";
        return userDao.queryUserById(sql, id);
    }

    @Override
    public User login(String username, String password) {
        String sql = "select * from news_user where username = ? and password = ?";
        return userDao.login(sql, username, password);
    }

    /**
     * 拼接字符串
     * @param criteria 条件
     * @return 根据不同的条件返回不同的sql语句
     */
    private String constrcriteriatWhereClause(UserCriteria criteria, List<Object> params) {
        String sql = "";

        if (StringUtils.isNotEmpty(criteria.getUsername())) {
            sql += " where username like ?";
            if (!criteria.getUsername().startsWith("%")) {
                params.add("%"+criteria.getUsername()+"%");
            }else {
                params.add(criteria.getUsername());
            }

        }else if (criteria.getId()> 0) {
            sql += " where id = ?";
            params.add(criteria.getId());
        }else if (StringUtils.isNotEmpty(criteria.getEmail())) {
            sql += " where email like ?";
            if (!criteria.getEmail().startsWith("%")) {
                params.add("%"+criteria.getEmail()+"%");
            }else {
                params.add(criteria.getEmail());
            }

        }else if (criteria.getUsertype()!=-1) {
            sql += " where usertype = ?";
            params.add(criteria.getUsertype());
        }

        return sql;
    }
}
