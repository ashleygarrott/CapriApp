package com.capricove.capricove.backend.data;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    public Menu(int id, String name, String section, List<String> categories, int price, String src, String description, List<String> tags, Map<String, HashMap<String, Integer>> options) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.categories = categories;
        this.price = price;
        this.src = src;
        this.description = description;
        this.tags = tags;
        this.options = options;
    }

    public Menu(int id, String name, String section, int price, String src, String description) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.categories = categories;
        this.price = price;
        this.src = src;
        this.description = description;
        this.options = new HashMap<String, HashMap<String, Integer>>();
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

    public void addOption(String option_category, String option_name, int option_price){
        if (!options.containsKey(option_category)){
            options.put(option_category, new HashMap<String, Integer>());
        }

        options.get(option_category).put(option_name, option_price);
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



    private int id;
    private String name;
    private String section;
    private List<String> categories;
    private int price;
    private String src;
    private List<String> tags;

    public Map<String, HashMap<String, Integer>> getOptions() {
        return options;
    }

    public void setOptions(Map<String, HashMap<String, Integer>> options) {
        this.options = options;
    }

    private Map<String, HashMap<String, Integer>> options;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}
