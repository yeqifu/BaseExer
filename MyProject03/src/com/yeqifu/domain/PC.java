package com.yeqifu.domain;

/**
 * @Author: 落亦-
 * @Date: 2020/2/15 19:56
 */
public class PC implements Equipment {
    /**
     * 机器型号
     */
    private String model;
    /**
     * 显示器名称
     */
    private String display;

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
}
