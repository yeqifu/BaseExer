package com.yeqifu.object.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/1/15 10:49
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle("白色",1,5);
        Circle c2 = new Circle("白色",1,4);
        boolean equals = c1.equals(c2);
        System.out.println(equals);
        System.out.println(c1.toString());
    }
}
