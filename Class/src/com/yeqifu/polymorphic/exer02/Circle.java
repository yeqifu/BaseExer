package com.yeqifu.polymorphic.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/14 17:03
 */
public class Circle extends GeometricObject {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, double weight){
        this.radius = radius;
        this.color = color;
        this.weight = weight;
    }
    @Override
    public double findArea(){
        return Math.PI*radius*radius;
    }
}
