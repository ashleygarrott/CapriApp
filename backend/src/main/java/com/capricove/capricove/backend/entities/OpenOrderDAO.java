package com.capricove.capricove.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "openOrders")
public class OpenOrderDAO {

    @Id
    @Column
    private String orderId;

    public OpenOrderDAO(){}

    public OpenOrderDAO(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
