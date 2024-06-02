package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.Order;

import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:46
 */
public interface DAO_Order {
    int addOrder(Order o);

    int updateOrder(Order o);

    int deleteOrder(int id);

    Order getOrderById(int id);

    List<Order> getAllOrders();
}
