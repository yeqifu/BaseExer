package com.yeqifu.object.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/1/15 10:42
 */
public class Circle extends GeometricObject {

    private double radius;

    public Circle() {
        color = "white";
        weight = 1.0;
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
        color = "white";
        weight = 1.0;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof  Circle){
            Circle o =(Circle)obj;
            return this.findArea() == o.findArea();
        }
        return false;
    }

    /**
     * 求圆的面积
     * @return
     */
    public double findArea(){
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {

        return "Circle [ radius = "+radius+"]";
    }
}
