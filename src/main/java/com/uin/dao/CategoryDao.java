package com.uin.dao;

import com.uin.entity.Category;

import java.util.List;

/**
 *
 */
public interface CategoryDao {

    List<Category> getCategory(String sql);

    boolean addCategory(String sql, Category category);

    boolean updateCategory(String sql, Category category);

    boolean delCategoryById(String sql, int id);

    Category getCategoryById(String sql, int id);
}
