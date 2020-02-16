package com.yeqifu.polymorphic.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/14 17:07
 */
public class MyRectangle extends GeometricObject{

    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public MyRectangle(double width, double height, String color, double weight){
        this.width = width;
        this.height = height;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public double findArea(){
        return width*height;
    }


}
