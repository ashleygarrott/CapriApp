package com.capricove.capricove.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class TagRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rowId")
    private String RowId;

    @Column(name = "menuId")
    private int menuId;

    @Column(name = "tag")
    private String tag;

    protected TagRow(){}

    public TagRow(int menuId, String tag) {
        this.menuId = menuId;
        this.tag = tag;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }




}