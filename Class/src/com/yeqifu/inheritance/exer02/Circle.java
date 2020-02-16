package com.yeqifu.inheritance.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/12 17:42
 */
public class Circle {
    private double radius;
    public Circle(){
        this.radius = 1;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public double findArea(){
        return Math.PI*radius*radius;
    }
}
