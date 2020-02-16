package com.yeqifu.abstractexer.exer02;

import com.yeqifu.abstractexer.exer02.MyDate;

/**
 * @Author: 落亦-
 * @Date: 2020/2/11 18:18
 */
public class SalariedEmployee extends Employee {

    private double monthlySalary;


    public SalariedEmployee(String name, Integer number, MyDate birthday) {
        super(name, number, birthday);
    }
    public SalariedEmployee(String name, Integer number, MyDate birthday,double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{"+super.toString()+
                '}';
    }
}
