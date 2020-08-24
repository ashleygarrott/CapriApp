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

    @Column
    private String orderTime;

    @Column
    private String address;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private String locationNotes;

    @Column
    private String status;

    public OrderDAO() {

    }

    public OrderDAO(String orderId, String username, String orderType, int orderPrice, String orderTime, String address, double latitude, double longitude, String locationNotes, String status) {
        this.orderId = orderId;
        this.username = username;
        this.orderType = orderType;
        this.orderPrice = orderPrice;
        this.orderTime = orderTime;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationNotes = locationNotes;
        this.status = status;
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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationNotes() {
        return locationNotes;
    }

    public void setLocationNotes(String locationNotes) {
        this.locationNotes = locationNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String confirmed) {
        this.status = confirmed;
    }
}

