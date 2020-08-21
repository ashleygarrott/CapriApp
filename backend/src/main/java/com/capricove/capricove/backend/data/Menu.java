package com.capricove.capricove.backend.data;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private int id;
    private String name;
    private String section;
    private List<String> categories;
    private int price;
    private String src;
    private List<String> tags;
    private String description;
    private List<OptionCategory> optionCategories;



    public Menu(int id, String name, String section, List<String> categories, int price, String src, String description, List<String> tags, List<OptionCategory> optionCategories) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.categories = categories;
        this.price = price;
        this.src = src;
        this.description = description;
        this.tags = tags;
        this.optionCategories = optionCategories;
    }

    public Menu(int id, String name, String section, int price, String src, String description) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.categories = categories;
        this.price = price;
        this.src = src;
        this.description = description;
        this.optionCategories = new ArrayList<OptionCategory>();
        this.tags = new ArrayList<String>();
        this.categories = new ArrayList<>();
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public void addTags(List<String> tags){
        for (String tag: tags){
            this.tags.add(tag);
        }
    }

    public void addOption(String optionCategory, String optionName, int optionPrice){
        for (OptionCategory oc: this.optionCategories){
            if (oc.getOptionCategoryName().equals(optionCategory)){
                oc.addOption(optionName, optionPrice);
                return;
            }
        }

        OptionCategory optionCategoryObject = new OptionCategory(optionCategory);
        optionCategoryObject.addOption(optionName, optionPrice);
        this.optionCategories.add(optionCategoryObject);
    }

    public void addCategory(String category){
        categories.add(category);
    }

    public void addCategories(List<String> categories){
        for (String category: categories){
            this.categories.add(category);
        }
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }





    public List<OptionCategory> getOptionCategories() {
        return optionCategories;
    }

    public void setOptionCategories(List<OptionCategory> optionCategories) {
        this.optionCategories = optionCategories;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
