package com.uin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private int usertype;

    public User(String username, String password, String email, int usertype) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.usertype = usertype;
    }
}
