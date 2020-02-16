package com.yeqifu.abstractexer.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/2/11 17:01
 */
public abstract class Employee {

    private String name;
    private Integer id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, Integer id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}

class Manager extends Employee{

    private double reward;

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public Manager(double reward) {
        this.reward = reward;
    }

    public Manager(String name, Integer id, double salary, double reward) {
        super(name, id, salary);
        this.reward = reward;
    }

    @Override
    public void work() {
        System.out.println("管理员工，提高公司效率");
    }
}

class CommonEmployee extends Employee{

    @Override
    public void work() {
        System.out.println("一线员工");
    }
}



