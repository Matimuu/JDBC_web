package com.admin.model;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/01 17:36
 */
public class Order_Detail {
    private Integer order_detail_id;
    private Integer order_id;
    private Integer game_id;
    private Integer quantity;
    private Float price;

    public Order_Detail(Integer order_detail_id, Integer order_id, Integer game_id, Integer quantity, Float price) {
        this.order_detail_id = order_detail_id;
        this.order_id = order_id;
        this.game_id = game_id;
        this.quantity = quantity;
        this.price = price;
    }

    public void setOrder_detail_id(Integer order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getOrder_detail_id() {
        return order_detail_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }
}
