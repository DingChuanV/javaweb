package com.uin.service.impl;

import com.uin.dao.CategoryDao;
import com.uin.dao.impl.CategoryDaoImpl;
import com.uin.entity.Category;
import com.uin.service.CategoryService;

import java.util.List;

/**
 *
 */
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> getCategory() {
        String sql = "select * from news_category";
        return categoryDao.getCategory(sql);

    }

    @Override
    public boolean addCategory(Category category) {
        String sql = "insert into news_category(name,createdate) values(?,?)";
        return categoryDao.addCategory(sql, category);
    }

    @Override
    public boolean updateCategory(Category category) {
        String sql = "update news_category set name = ? where id=?";
        return categoryDao.updateCategory(sql, category);
    }

    @Override
    public boolean delCategoryById(int id) {
        String sql = "delete from news_category where id = ?";
        return categoryDao.delCategoryById(sql,id);
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "select * from news_category where id = ?";
        return categoryDao.getCategoryById(sql,id);
    }
}
