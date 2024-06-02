package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 01:34
 */
@Repository
public class DAO_Order_Impl implements DAO_Order{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addOrder(Order order) {
        String sql = "INSERT INTO `Order` (user_id, order_date, status) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, order.getId(), order.getOrderDate(), order.getStatus());
    }

    @Override
    public int updateOrder(Order order) {
        String sql = "UPDATE `Order` SET user_id = ?, order_date = ?, status = ? WHERE order_id = ?";
        return jdbcTemplate.update(sql, order.getId(), order.getOrderDate(), order.getStatus(), order.getUserId());
    }

    @Override
    public int deleteOrder(int orderId) {
        String sql = "DELETE FROM `Order` WHERE order_id = ?";
        return jdbcTemplate.update(sql, orderId);
    }

    @Override
    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM `Order` WHERE order_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Order.class), orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM `Order`";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }
}
