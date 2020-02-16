package com.yeqifu.polymorphic.exer02;

/**
 * @Author: 落亦-
 * @Date: 2020/1/14 17:10
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle circle = new Circle(5,"黑色",1.0);
        MyRectangle myRectangle = new MyRectangle(5,5,"白色",1.0);
        test.equalsArea(circle,myRectangle);
        test.displayGeometricObject(circle);
        test.displayGeometricObject(myRectangle);
    }

    public void equalsArea(GeometricObject g1,GeometricObject g2){
        double area1 = g1.findArea();
        double area2 = g2.findArea();
        if (area1==area2){
            System.out.println("面积相等");
        }else {
            System.out.println("面积不相等");
        }
    }

    public void displayGeometricObject(GeometricObject g){
        System.out.println("面积为："+g.findArea());
    }
}
