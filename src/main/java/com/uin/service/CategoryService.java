package com.uin.service;

import com.uin.entity.Category;

import java.util.List;

/**
 *
 */
public interface CategoryService {
    List<Category> getCategory();

    boolean addCategory(Category category);

    boolean updateCategory(Category category);

    boolean delCategoryById(int id);

    Category getCategoryById(int id);

}
