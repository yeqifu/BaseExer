package com.yeqifu.inheritance.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/12 17:47
 */
public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.setRadius(5);
        cylinder.setLength(2);
        double volume = cylinder.findVolume();
        System.out.println("面积为："+volume);
    }
}
