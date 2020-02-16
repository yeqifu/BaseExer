package com.yeqifu.object.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/1/15 10:01
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order(1,"luoyi");
        Order order1 = new Order(2,"jiucheng");
        boolean equals = order.equals(order1);
        System.out.println(equals);

        Order order2 = new Order(2,"luoyi");
        Order order3 = new Order(2,"luoyi");
        boolean equals1 = order2.equals(order3);
        System.out.println(equals1);
    }
}
