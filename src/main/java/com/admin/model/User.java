package com.admin.model;

import java.sql.Timestamp;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/01 17:24
 */
public class User {
    private Integer user_id;
    private String username;
    private String email;
    private String password;
    private Timestamp created_at;
    private Integer total_orders;

    public User(Integer user_id, String username, String email, String password) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Integer user_id, String username, String email, String password, Timestamp created_at, Integer total_orders) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.total_orders = total_orders;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setTotal_orders(Integer total_orders) {
        this.total_orders = total_orders;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Integer getTotal_orders() {
        return total_orders;
    }
}
