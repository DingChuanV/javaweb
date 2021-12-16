package com.uin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatCriteria {

    //
    private String name;

    //分页查询的当前页
    private int currentPage;
    //分页查询的页面大小
    private int pageSize;
}
