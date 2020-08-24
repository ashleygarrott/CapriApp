package com.capricove.capricove.backend.data;

import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private String orderId;

    private String userId;

    private int orderPrice;

    private String orderType;

    private List<Order> orders;

    private String orderTime;

    private String address;

    private double latitude;

    private double longitude;

    private String locationNotes;



    public OrderDTO(){}

    public OrderDTO(String userId, int orderPrice, String orderType) {
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
        this.orders = new ArrayList();
    }

    public OrderDTO(String orderId, String userId, int orderPrice, String orderType, List<Order> orders, String orderTime, String address, double latitude, double longitude, String locationNotes) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
        this.orders = orders;
        this.orderTime = orderTime;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationNotes = locationNotes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
