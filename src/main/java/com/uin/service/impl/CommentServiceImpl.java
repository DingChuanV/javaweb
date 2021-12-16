package com.uin.service.impl;

import com.uin.dao.CommentDao;
import com.uin.dao.impl.CommentDaoImpl;
import com.uin.entity.Comment;
import com.uin.service.CommentService;

import java.util.List;

/**
 *
 */
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao = new CommentDaoImpl();

    @Override
    public List<Comment> queryAllComment() {
        String sql = "select * from news_comment";
        return commentDao.queryAllComment(sql);
    }

    @Override
    public boolean addComment(Comment comment) {
        String sql = "insert into news_comment(`newsId`,`content`,`author`,`ip`,`createdate`) values(?,?,?,?,SYSDATE())";
        return commentDao.addComment(sql, comment);
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "delete from news_comment where id = ?";
        return commentDao.deleteById(sql, id);
    }

    @Override
    public boolean updateComment(Comment comment) {
        String sql = "update news_comment set content = ? where id = ?";
        return commentDao.updateComment(sql, comment);
    }

    @Override
    public List<Comment> queryByNewsId(int id) {
        String sql = "select * from news_comment where id = ?";
        return commentDao.queryByNewsId(sql, id);
    }
}
