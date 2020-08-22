package com.capricove.capricove.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderDAO {

    @Id
    @Column
    private String orderId;

    @Column
    private String username;

    @Column
    private String orderType;

    @Column
    private int orderPrice;

    public OrderDAO() {

    }

    public OrderDAO(String orderId, String username, String orderType, int orderPrice) {
        this.orderId = orderId;
        this.username = username;
        this.orderType = orderType;
        this.orderPrice = orderPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
}
