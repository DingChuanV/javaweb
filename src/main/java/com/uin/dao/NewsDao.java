package com.uin.dao;

import com.uin.entity.NewsCriteria;
import com.uin.entity.News;

import java.util.List;

/**
 * 新闻持久层
 */
public interface NewsDao {

    /**
     * 查询
     * @param sql 传入的sql语句
     * @return 返回查询结果
     */
    List<News> getNewsList(String sql);

    /**
     * 添加新闻
     * @param sql 传入的语句
     * @param news 添加的新闻内容
     * @return 是否成功
     */
    boolean add(String sql,News news);

    /**
     * 删除新闻
     * @param sql 传入的语句
     * @param id 通过id
     * @return 是否成功
     */
    boolean delete(String sql,int id);

    /**
     * 修改新闻
     * @param sql 传入的语句
     * @param news 修改的内容
     * @return 是否成功
     */
    boolean update(String sql,News news);


    /**
     * 通过id查询新闻
     * @param sql sql
     * @param id 新闻id
     * @return 返回当前新闻数据
     */
    News getNewsById(String sql, int id);

    /**
     * 通过条件查询新闻的总数量
     * @param sql sql语句
     * @return 返回查询总数
     */
    int countNews(String sql, NewsCriteria criteria, Object[] params);

    /**
     *
     * @param sql sql语句
     * @param criteria 查询条件类
     * @return 返回分页数据
     */
    List<News> getListWithPagingInfo(String sql, NewsCriteria criteria, Object[] params);
}
