package com.uin.dao;

import com.uin.entity.Comment;

import java.util.List;

/**
 *
 */
public interface CommentDao {

    List<Comment> queryAllComment(String sql);

    boolean addComment(String sql, Comment comment);

    boolean deleteById(String sql, int id);

    boolean updateComment(String sql, Comment comment);

    List<Comment> queryByNewsId(String sql, int id);

}
