package com.uin.service;

import com.uin.entity.NewsCriteria;
import com.uin.entity.News;
import com.uin.util.PageHelper;

import java.util.List;

/**
 * 新闻service类
 */
public interface NewsService {

    /**
     * 查询
     * @return 返回查询结果
     */
    List<News> getNewsList();

    /**
     * 添加新闻
     * @param news 添加的新闻内容
     * @return 是否成功
     */
    boolean add(News news);

    /**
     * 删除新闻
     * @param id 通过id
     * @return 是否成功
     */
    boolean delete(int id);

    /**
     * 修改新闻
     * @param news 修改的内容
     * @return 是否成功
     */
    boolean update(News news);

    /**
     * 通过id查询新闻
     * @param id 新闻id
     * @return 返回当前新闻数据
     */
    News getNewsById(int id);

    /**
     * 通过条件查询新闻的总数量
     * @param criteria 查询条件类
     * @return 返回查询总数
     */
    int countNews(NewsCriteria criteria);


    /**
     * @param criteria 查询条件类
     * @return 返回页面帮助类
     */
    PageHelper<News> getListWithPagingInfo(NewsCriteria criteria);

}
