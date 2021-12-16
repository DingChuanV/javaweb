package com.uin.util;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class PageHelper<T> {
    //当前页面
    private int currentPage = 1;

    //总共页面
    private int totalPageCount = 1;

    //每页显示的数量
    private int pageSize = 0;

    //总共多少条记录
    private int totalCount = 0;

    //分页的数据
    private List<T> data;


    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage > 0 ? currentPage : 1;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = Math.max(pageSize, 0);
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = Math.max(totalCount, 0);
    }


    public int getTotalPageCount() {
        if (totalCount % pageSize == 0) {
            return totalCount/pageSize;
        }else if (totalCount % pageSize != 0){
            return totalCount / pageSize + 1;
        }else {
            return 0;
        }
    }
}
