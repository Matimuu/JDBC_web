package com.admin.JDBC_try.model;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:36
 */
public class OrderDetail {
    int id;
    int orderId;
    int gameId;
    int quantity;
    Float price;

    public OrderDetail(int id, int orderId, int gameId, int quantity, Float price) {
        this.id = id;
        this.orderId = orderId;
        this.gameId = gameId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", gameId=" + gameId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
