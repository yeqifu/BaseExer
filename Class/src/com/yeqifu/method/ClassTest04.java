package com.yeqifu.method;

/**
 * 问题：定义一个Circle类，包含一个double型的radius属性代表圆的半径，一个findArea()方法返回圆的面积
 *      定义一个类PassObject,在类中定义一个方法printAreas(),该方法的定义如下：
 *          public void printAreas(Circle c,int time)
 *          在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积
 *          例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积
 *      在main方法中调用printAreas()方法，调用完毕后输出当前半径值。
 * @Author: 落亦-
 * @Date: 2020/1/7 10:49
 */
public class ClassTest04 {

    public static void main(String[] args) {
        Circle c = new Circle();
        PassObject passObject = new PassObject();
        passObject.printAreas(c,5);
        System.out.println("now radius is:"+c.radius);

    }

}

class Circle{
    double radius;
    public double findArea(){

        double area = Math.PI*radius*radius;

        return area;
    }
}

class PassObject{

    public void printAreas(Circle c,int time){
        for (int i = 1; i < time + 1; i++) {
            c.radius = i;
            double area = c.findArea();
            System.out.println("Radius"+"    Area");
            System.out.println(i+"        "+area);
        }

        c.radius = time+1;
    }

}