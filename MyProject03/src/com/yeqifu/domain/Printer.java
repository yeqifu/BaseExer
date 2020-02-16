package com.yeqifu.domain;

/**
 * @Author: 落亦-
 * @Date: 2020/2/15 20:01
 */
public class Printer implements Equipment {

    /**
     * 机器型号
     */
    private String name;

    /**
     * 机器类型
     */
    private String type;

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name+"("+type+")";
    }
}
