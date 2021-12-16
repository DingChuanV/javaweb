package com.uin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询的条件类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCriteria {

    //新闻的种类id
    private int categoryId;
    //新闻标题
    private String title;
    //分页查询的当前页
    private int currentPage;
    //分页查询的页面大小
    private int pageSize;

    public NewsCriteria(int categoryId, String title) {
        this.categoryId = categoryId;
        this.title = title;
    }
}
