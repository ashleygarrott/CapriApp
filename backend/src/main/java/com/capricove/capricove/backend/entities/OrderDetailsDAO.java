package com.capricove.capricove.backend.entities;

import com.capricove.capricove.backend.repositories.OrderDetailRepository;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "order_details")
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

    @Column
    private String menuName;

    @Column
    private String options;

    @Column
    private int menuPrice;

    public OrderDetailsDAO(){}

    public OrderDetailsDAO(String orderId, int menuId, int quantity, String menuName, String options, int menuPrice) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.menuName = menuName;
        this.options = options;
        this.menuPrice = menuPrice;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }
}
