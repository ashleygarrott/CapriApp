package com.capricove.capricove.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "menus", schema = "capriapp")
public class MenuDAO {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "section")
    private String section;

    @Column(name = "price")
    private int price;

    @Column(name = "src")
    private String src;

    @Column(name = "description")
    private String description;

    public MenuDAO(){}

    public MenuDAO(int id, String name, String section, int price, String src, String description) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.price = price;
        this.src = src;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
