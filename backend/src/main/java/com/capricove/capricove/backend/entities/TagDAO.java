package com.capricove.capricove.backend.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class TagDAO {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "rowId")
    private String rowId;

    @Column(name = "menuId")
    private int menuId;

    @Column(name = "tag")
    private String tag;

    protected TagDAO(){}

    public TagDAO(int menuId, String tag) {
        this.menuId = menuId;
        this.tag = tag;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        rowId = rowId;
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