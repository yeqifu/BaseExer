package com.yeqifu.abstractexer.exer02;

import com.yeqifu.abstractexer.exer02.MyDate;

/**
 * @Author: 落亦-
 * @Date: 2020/2/11 19:44
 */
public class HourlyEmployee extends Employee {

    /**
     * 没小时的工资
     */
    private Integer wage;
    /**
     * 月工作的小时树
     */
    private Integer hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(Integer wage) {
        this.wage = wage;
    }

    public HourlyEmployee(String name, Integer number, MyDate birthday) {
        super(name, number, birthday);
    }
    public HourlyEmployee(String name, Integer number, MyDate birthday,Integer wage,Integer hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return getWage()*getHour();
    }

    @Override
    public String toString() {
        return "HourlyEmployee{"+super.toString()+"}";
    }
}
