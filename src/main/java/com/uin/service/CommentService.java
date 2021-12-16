package com.uin.service;

import com.uin.entity.Comment;

import java.util.List;

/**
 *
 */
public interface CommentService {
    List<Comment> queryAllComment();

    boolean addComment(Comment comment);

    boolean deleteById(int id);

    boolean updateComment(Comment comment);

    List<Comment> queryByNewsId(int id);
}
