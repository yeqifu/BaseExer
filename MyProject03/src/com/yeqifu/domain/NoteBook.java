package com.yeqifu.domain;

/**
 * @Author: 落亦-
 * @Date: 2020/2/15 19:58
 */
public class NoteBook implements Equipment {
    /**
     * 型号
     */
    private String model;
    /**
     * 价格
     */
    private double price;

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
}
