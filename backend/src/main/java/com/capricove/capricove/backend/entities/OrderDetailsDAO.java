package com.capricove.capricove.backend.entities;

import com.capricove.capricove.backend.repositories.OrderDetailRepository;

import javax.persistence.*;


@Entity
@Table(name = "order_details", schema = "capriapp")
public class OrderDetailsDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int rowId;

    @Column
    private String orderId;

    @Column
    private int menuId;

    @Column
    private int quantity;

    public OrderDetailsDAO(){}

    public OrderDetailsDAO(String orderId, int menuId, int quantity) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
