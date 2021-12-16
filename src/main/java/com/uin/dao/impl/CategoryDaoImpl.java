package com.uin.dao.impl;

import com.uin.dao.BaseDao;
import com.uin.dao.CategoryDao;
import com.uin.entity.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public List<Category> getCategory(String sql) {
        executeSQL(sql);

        return getResult();
    }

    @Override
    public boolean addCategory(String sql, Category category) {
        int n = executeUpdate(sql, category.getName(),new Date());
        
        return n==1;
    }

    @Override
    public boolean updateCategory(String sql, Category category) {
        int n = executeUpdate(sql, category.getName(),category.getId());
        
        return n==1;
    }

    @Override
    public boolean delCategoryById(String sql, int id) {
        int n = executeUpdate(sql, id);
        
        return n==1;
    }

    @Override
    public Category getCategoryById(String sql, int id) {
        executeSQL(sql, id);

        return getResult().get(0);
    }

    private List<Category> getResult() {
        ArrayList<Category> categories = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date createdate = rs.getDate("createdate");

                categories.add(new Category(id, name, createdate));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeResource();
        }

        return categories;
    }
}
