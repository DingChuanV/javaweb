package com.uin.dao.impl;

import com.uin.dao.BaseDao;
import com.uin.dao.CommentDao;
import com.uin.entity.Comment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public List<Comment> queryAllComment(String sql) {
        ArrayList<Comment> comments = new ArrayList<>();

        executeSQL(sql);

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int newsId = rs.getInt("newsId");
                String content = rs.getString("content");
                String author = rs.getString("author");
                String ip = rs.getString("ip");
                Date createdate = rs.getDate("createdate");

                comments.add(new Comment(id, newsId, content, author, ip, createdate));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource();
        }
        return comments;
    }
    @Override
    public boolean addComment(String sql, Comment comment) {
        int n = executeUpdate(sql, comment.getNewsId(), comment.getContent(), comment.getAuthor(), comment.getIp());
        
        return n==1;
    }

    @Override
    public boolean deleteById(String sql, int id) {
        int n = executeUpdate(sql, id);
        
        return n==1;
    }

    @Override
    public boolean updateComment(String sql, Comment comment) {
        int n = executeUpdate(sql, comment.getContent(), comment.getId());
        
        return n==1;
    }

    @Override
    public List<Comment> queryByNewsId(String sql, int id) {
        return null;
    }
}
