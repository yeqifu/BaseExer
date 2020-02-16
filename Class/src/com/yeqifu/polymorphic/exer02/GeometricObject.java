package com.yeqifu.polymorphic.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/14 16:59
 */
public class GeometricObject {
    protected String color;
    protected double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    protected void GeometricObject(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public double findArea(){
        return 0.0;
    }
}
