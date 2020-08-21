package com.capricove.capricove.backend.data;

import java.util.ArrayList;
import java.util.List;

public class OptionCategory {

    private String optionCategoryName;

    private List<Option> options;

    public OptionCategory(String optionCategoryName){
        this.optionCategoryName = optionCategoryName;
        options = new ArrayList<Option>();
    }


    public OptionCategory(String optionCategoryName, List<Option> options) {
        this.optionCategoryName = optionCategoryName;
        this.options = options;
    }

    public void addOption(String optionName, int optionPrice){
        this.options.add(new Option(optionName, optionPrice));
    }

    public String getOptionCategoryName() {
        return optionCategoryName;
    }

    public void setOptionCategoryName(String optionCategoryName) {
        this.optionCategoryName = optionCategoryName;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
