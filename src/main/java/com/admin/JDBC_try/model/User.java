package com.admin.JDBC_try.model;

import java.sql.Timestamp;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:29
 */
public class User {
    int id;
    String username;
    String email;
    String password;
    Timestamp createdAt;
    int totalOrders;

    public User(String username, String email, String password, Timestamp createdAt, int totalOrders) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.totalOrders = totalOrders;
    }

    public User(int id, String username, String email, String password, Timestamp createdAt, int totalOrders) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.totalOrders = totalOrders;
    }

    public User(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", totalOrders=" + totalOrders +
                '}';
    }
}
