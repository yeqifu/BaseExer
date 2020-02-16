package com.yeqifu.inheritance.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/12 17:44
 */
public class Cylinder extends Circle{
    private double length;
    public Cylinder(){
        length = 1;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getLength(){
        return length;
    }



    public double findVolume(){
        return findArea()*getLength();
    }
}
