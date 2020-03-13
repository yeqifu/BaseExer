package com.yeqifu.exer01.preparedStatement;

/**
 * @Author: 落亦-
 * @Date: 2020/3/13 10:44
 */
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer orderAge;

    public Order() {
    }

    public Order(Integer orderId, String orderName, Integer orderAge) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderAge = orderAge;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderAge() {
        return orderAge;
    }

    public void setOrderAge(Integer orderAge) {
        this.orderAge = orderAge;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderAge='" + orderAge + '\'' +
                '}';
    }
}
