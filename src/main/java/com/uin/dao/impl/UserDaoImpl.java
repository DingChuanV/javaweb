package com.uin.dao.impl;

import com.uin.dao.BaseDao;
import com.uin.dao.UserDao;
import com.uin.entity.User;
import com.uin.entity.UserCriteria;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> queryUsers(String sql, UserCriteria criteria, Object[] args){
        //添加的条件查询
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(args));

        //设置分页查询的参数
        params.add((criteria.getCurrentPage() - 1) * criteria.getPageSize());
        params.add(criteria.getPageSize());

        executeSQL(sql, params.toArray());

        return getQueryResult();
    }

    @Override
    public boolean addUser(String sql, User user) {
        int n = executeUpdate(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getUsertype());
        
        return n==1;
    }

    @Override
    public boolean deleteUserById(String sql, int id) {
        int n = executeUpdate(sql, id);
        
        return n==1;
    }

    @Override
    public boolean updateUser(String sql, User user) {
        int n = executeUpdate(sql,user.getUsername(), user.getPassword(),user.getEmail(),user.getUsertype(), user.getId());
        
        return n==1;
    }

    @Override
    public User queryUserById(String sql, int id) {

        executeSQL(sql, id);
        //返回的user对象

        return getQueryResult().get(0);
    }

    @Override
    public User login(String sql, String username, String password) {

        executeSQL(sql, username, password);
        List<User> result = getQueryResult();

        return !result.isEmpty()?result.get(0):null;
    }
    @Override
    public int countNews(String sql, UserCriteria criteria, Object[] params) {

        executeSQL(sql, params);

        int countNews = 0;
        try {
            while (rs.next()) {
                countNews = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countNews;
    }


    /**
     * 获取ResultSet得到的结果
     * @return 获取ResultSet得到的结果
     */
    private List<User> getQueryResult() {

        List<User> userList = new ArrayList<>();

        try {
            while (rs.next()) {
                User user = new User();
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int usertype = rs.getInt("usertype");

                user.setId(id)
                        .setUsername(username)
                        .setPassword(password)
                        .setEmail(email)
                        .setUsertype(usertype);

                userList.add(user);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
