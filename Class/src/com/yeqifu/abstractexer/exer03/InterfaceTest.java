package com.yeqifu.abstractexer.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/2/13 12:18
 */
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(15);
        ComparableCircle c2 = new ComparableCircle(10);
        Circle c = new Circle(6);
        int i = c1.compareTo(c2);
        if (i>0){
            System.out.println("c1的半径大");
        }else if(i==0){
            System.out.println("c1和c2的半径一样大");
        }else{
            System.out.println("c2半径大");
        }
    }
}
