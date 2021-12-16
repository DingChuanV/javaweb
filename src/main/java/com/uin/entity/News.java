package com.uin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private int id;
    private int categoryId;
    private String title;
    private String summary;
    private String content;
    private String picpath;
    private String author;
    private Date createdate;
    private Date modifydate;
    private List<News> newsList;


    public News(int id, int categoryId, String title, String summary, String content, String picpath, String author, Date createdate, Date modifydate) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.picpath = picpath;
        this.author = author;
        this.createdate = createdate;
        this.modifydate = modifydate;
    }

    public News(int id, String title, String author, Date createdate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdate = createdate;
    }
}
