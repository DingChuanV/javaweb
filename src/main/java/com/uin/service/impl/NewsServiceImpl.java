package com.uin.service.impl;

import com.uin.dao.NewsDao;
import com.uin.dao.impl.NewsDaoImpl;
import com.uin.entity.NewsCriteria;
import com.uin.entity.News;
import com.uin.service.NewsService;
import com.uin.util.PageHelper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NewsServiceImpl implements NewsService {

    private final NewsDao newsDao = new NewsDaoImpl();

    @Override
    public List<News> getNewsList() {
        String sql = "select*from news_detail";
        return newsDao.getNewsList(sql);
    }

    @Override
    public boolean add(News news) {
        String sql = "insert into news_detail (categoryId,title,summary,content,picpath,author,createdate) " +
                " VALUES (?,?,?,?,?,?,SYSDATE())" ;

        return newsDao.add( sql, news );
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from news_detail where id = ?";
        return newsDao.delete(sql,id);
    }

    @Override
    public boolean update(News news) {
        return newsDao.update("update news_detail set categoryId = ?,title = ?,summary = ?,content = ?,picpath = ?,author = ? where id = ?",news);
    }

    @Override
    public News getNewsById(int id) {
        String sql = "select * from news_detail where id = ?";
        return newsDao.getNewsById(sql,id);
    }

    @Override
    public int countNews(NewsCriteria criteria) {
        List<Object> params = new ArrayList<>();
        //得到sql语句
        String sql = "select count(1) from news_detail " + constructWhereClause(criteria,params);

        return newsDao.countNews(sql, criteria,params.toArray());
    }

    @Override
    public PageHelper<News> getListWithPagingInfo(NewsCriteria criteria) {
        //得到sql语句
        String sql = "select * from news_detail";

        List<Object> params = new ArrayList<>();
        sql += constructWhereClause(criteria,params);
        //分页语句
        sql += " limit ?,?";

        PageHelper<News> pageHelper = new PageHelper<>();

        //分页查询的信息
        List<News> newsList = newsDao.getListWithPagingInfo(sql, criteria,params.toArray());

        //条件查询的总数
        int totalCount = countNews(criteria);
        pageHelper.setTotalCount(totalCount);
        pageHelper.setPageSize(criteria.getPageSize());
        pageHelper.setCurrentPage(criteria.getCurrentPage());
        pageHelper.setData(newsList);

        return pageHelper;
    }



    /**
     * 拼接字符串
     * @param criteria 条件
     * @return 根据不同的条件返回不同的sql语句
     */
    private String constructWhereClause(NewsCriteria criteria, List<Object> params) {
        String sql = "";
        boolean whereClause = false;
        if (criteria.getCategoryId() > 0) {
            sql += " where categoryId = ?";
            params.add(criteria.getCategoryId());
            whereClause = true;
        }
        if (criteria.getTitle() != null && !"".equals(criteria.getTitle())){
            if (!criteria.getTitle().startsWith("%")) {
                criteria.setTitle("%"+criteria.getTitle()+"%");
            }
            if (whereClause) {
                sql += " and title like ?";
            }else {
                sql += " where title like ?";
            }
            params.add(criteria.getTitle());
        }
        return sql;
    }

}
