package com.capricove.capricove.backend.data;

import org.aspectj.weaver.ast.Or;

import java.util.List;

public class Order {

    private int menuId;

    private int quantity;

    private String menuName;

    private List<String> options;

    private String optionString;

    private int menuPrice;

    public Order(){}

    public Order(int menuId, int quantity, String menuName, List<String> options, int menuPrice) {
        this.menuId = menuId;
        this.quantity = quantity;
        this.menuName = menuName;
        this.options = options;
        this.menuPrice = menuPrice;
    }

    public Order(int menuId, int quantity, String menuName, String optionString, int menuPrice) {
        this.menuId = menuId;
        this.quantity = quantity;
        this.menuName = menuName;
        this.optionString = optionString;
        this.menuPrice = menuPrice;
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getOptionString() {
        return optionString;
    }

    public void setOptionString(String optionString) {
        this.optionString = optionString;
    }
}
