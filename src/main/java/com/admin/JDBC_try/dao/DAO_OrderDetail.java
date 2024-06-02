package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.OrderDetail;

import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:47
 */
public interface DAO_OrderDetail {
    void addOrderDetail(OrderDetail ol);
    void updateOrderDetail(OrderDetail ol);
    void deleteOrderDetail(int orderLogId);
    OrderDetail getOrderDetailById(int orderLogId);
    List<OrderDetail> getAllOrderDetails();
    List<OrderDetail> getOrderDetailsByOrderId(int orderId);
}
