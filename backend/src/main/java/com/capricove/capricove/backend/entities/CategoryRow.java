package com.capricove.capricove.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rowId")
    private String RowId;

    @Column(name = "menuId")
    private int menuId;

    @Column(name = "category")
    private String category;

    public CategoryRow(){}

    public CategoryRow(int menuId, String category) {
        this.menuId = menuId;
        this.category = category;
    }

    public String getRowId() {
        return RowId;
    }

    public void setRowId(String rowId) {
        RowId = rowId;
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
