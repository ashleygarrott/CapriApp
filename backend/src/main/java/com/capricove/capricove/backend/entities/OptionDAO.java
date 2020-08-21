package com.capricove.capricove.backend.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "options", schema = "capriapp")
public class OptionDAO {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "rowId")
    private String rowId;

    @Column(name = "menuId")
    private int menuId;

    @Column(name = "optionCategory")
    private String optionCategory;

    @Column(name = "optionName")
    private String optionName;

    @Column(name = "optionPrice")
    private int optionPrice;

    public OptionDAO(){}

    public OptionDAO(int menuId, String optionCategory, String optionName, int optionPrice) {
        this.menuId = menuId;
        this.optionCategory = optionCategory;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
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

    public String getOptionCategory() {
        return optionCategory;
    }

    public void setOptionCategory(String optionCategory) {
        this.optionCategory = optionCategory;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(int optionPrice) {
        this.optionPrice = optionPrice;
    }
}
