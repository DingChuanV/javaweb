package com.uin.dao.impl;

import com.uin.dao.BaseDao;
import com.uin.dao.NewsDao;
import com.uin.entity.NewsCriteria;
import com.uin.entity.News;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

    @Override
    public List<News> getNewsList(String sql){

        executeSQL(sql);
        //得到结果集中的数据
        return getQueryResult();

    }

    @Override
    public boolean add(String sql,News news) {
        int flag = executeUpdate(sql,
                    news.getCategoryId(),
                    news.getTitle(),
                    news.getSummary(),
                    news.getContent(),
                    news.getPicpath(),
                    news.getAuthor()
                );

        return flag == 1;
    }

    @Override
    public boolean delete(String sql,int id) {
        int flag = executeUpdate(sql, id);

        return flag==1;
    }

    @Override
    public boolean update(String sql, News news) {
        int flag = executeUpdate(sql, news.getCategoryId(),
                news.getTitle(),
                news.getSummary(),
                news.getContent(),
                news.getPicpath(),
                news.getAuthor(),
                news.getId());

        return flag==1;
    }

    @Override
    public News getNewsById(String sql, int id) {

        executeSQL(sql,id);

        //由于通过id只会查到一条数据，因此只需要获取这第一条数据
        return getQueryResult().get(0);
    }

    @Override
    public int countNews(String sql, NewsCriteria criteria, Object[] params) {


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

    @Override
    public List<News> getListWithPagingInfo(String sql, NewsCriteria criteria, Object[] args) {
        ArrayList<Object> params = new ArrayList<>();
        //添加的条件查询
        for (int i = 0; i < args.length; i++) {
            params.add(args[i]);
        }

        //设置分页查询的参数
        params.add((criteria.getCurrentPage() - 1) * criteria.getPageSize());
        params.add(criteria.getPageSize());

        executeSQL(sql, params.toArray());

        return getQueryResult();
    }


    /**
     * 获取ResultSet得到的结果
     * @return 获取ResultSet得到的结果
     */
    private List<News> getQueryResult() {

        List<News> newsList = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int categoryId = rs.getInt("categoryId");
                String title = rs.getString("title");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Date createdate = rs.getTimestamp("createdate");
                String picpath = rs.getString("picpath");
                Date modifydate = rs.getTimestamp("modifydate");

                newsList.add(new News(id,categoryId, title, summary, content,picpath, author, createdate,modifydate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource();
        }

        return newsList;
    }

}
