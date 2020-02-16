package com.yeqifu.Class;

/**
 * 利用面向对象的编程方法，设计类Circle机算圆的面积
 * @Author: 落亦-
 * @Date: 2020/1/2 7:59
 */
public class CircleTest {

    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.radius=3;
        double circleArea = circle.getCircleArea();
        System.out.println("圆的面积为："+circleArea);

    }

}

class Circle{
    double radius;

    double getCircleArea(){
//        double area = 3.14*radius*radius;
        double area = Math.PI*radius*radius;
        return area;
    }
}
