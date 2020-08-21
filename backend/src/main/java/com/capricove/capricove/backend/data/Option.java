package com.capricove.capricove.backend.data;

public class Option {

    private String optionName;

    private int optionPrice;

    public Option(String optionName, int optionPrice) {
        this.optionName = optionName;
        this.optionPrice = optionPrice;
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
