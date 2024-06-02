package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 02:03
 */
@Repository
public class DAO_OrderDetail_Impl implements DAO_OrderDetail{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO Order_Detail (order_id, game_id, quantity, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderDetail.getOrderId(), orderDetail.getGameId(), orderDetail.getQuantity(), orderDetail.getPrice());
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        String sql = "UPDATE Order_Detail SET order_id = ?, game_id = ?, quantity = ?, price = ? WHERE order_detail_id = ?";
        jdbcTemplate.update(sql, orderDetail.getOrderId(), orderDetail.getGameId(), orderDetail.getQuantity(), orderDetail.getPrice(), orderDetail.getId());
    }

    @Override
    public void deleteOrderDetail(int orderDetailId) {
        String sql = "DELETE FROM Order_Detail WHERE order_detail_id = ?";
        jdbcTemplate.update(sql, orderDetailId);
    }

    @Override
    public OrderDetail getOrderDetailById(int orderDetailId) {
        String sql = "SELECT * FROM Order_Detail WHERE order_detail_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(OrderDetail.class), orderDetailId);
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        String sql = "SELECT * FROM Order_Detail";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderDetail.class));
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        String sql = "SELECT * FROM Order_Detail WHERE order_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderDetail.class), orderId);
    }
}
