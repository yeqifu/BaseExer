package com.yeqifu.domain;

/**
 * Customer实体类对象，用来封装customer对象
 * @Author: 落亦-
 * @Date: 2020/1/10 11:49
 */
public class Customer {

    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户性别
     */
    private char sex;
    /**
     * 客户年龄
     */
    private int age;
    /**
     * 客户手机号
     */
    private String telphone;
    /**
     * 客户邮箱
     */
    private String email;

    public Customer() {
    }

    public Customer(String name, char sex, int age, String telphone, String email) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.telphone = telphone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
