package com.capricove.capricove.backend.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryDAO {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "rowId")
    private String rowId;

    @Column(name = "menuId")
    private int menuId;

    @Column(name = "category")
    private String category;

    public CategoryDAO(){}

    public CategoryDAO(int menuId, String category) {
        this.menuId = menuId;
        this.category = category;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
