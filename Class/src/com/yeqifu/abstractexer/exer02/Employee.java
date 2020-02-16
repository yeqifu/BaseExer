package com.yeqifu.abstractexer.exer02;

import com.yeqifu.abstractexer.exer02.MyDate;

/**
 * @Author: 落亦-
 * @Date: 2020/2/11 18:09
 */
public abstract class Employee {
    private String name;
    private Integer number;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, Integer number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString();
    }

    public abstract double earnings();
}
