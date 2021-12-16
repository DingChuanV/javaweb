package com.uin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    private String name;
    private Date createdate;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name, Date createdate) {
        this.name = name;
        this.createdate = createdate;
    }
}
