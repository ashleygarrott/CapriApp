package com.capricove.capricove.backend.data;

public class ProductCardDTO {

    private String name;

    private String description;

    private int price;

    private String src;

    public ProductCardDTO(String name, String description, int price, String src) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
