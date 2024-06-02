package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:52
 */
@Repository
public class DAO_User_Impl implements DAO_User {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DAO_User_Impl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO User (username, email, password, created_at, total_orders) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getCreatedAt(), user.getTotalOrders());
    }

    @Override
    public int updateUser(User user) {
        String sql = "UPDATE User SET username = ?, email = ?, password = ?, total_orders = ? WHERE user_id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getTotalOrders(), user.getId());
    }

    @Override
    public int deleteUser(int userId) {
        String sql = "DELETE FROM User WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId);
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM User WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM User";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}

