package com.admin.model;

import java.sql.Timestamp;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/01 17:32
 */
public class Order {
    private Integer order_id;
    private Integer user_id;
    private Timestamp order_date;
    private String status;

    public Order(Integer order_id, Integer user_id, Timestamp order_date, String status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.status = status;
    }

    public Order(Integer order_id, Integer user_id, Timestamp order_date) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.order_date = order_date;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public String getStatus() {
        return status;
    }
}
