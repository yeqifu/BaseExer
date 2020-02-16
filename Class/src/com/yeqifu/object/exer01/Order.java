package com.yeqifu.object.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/1/15 9:56
 */
public class Order {
    private int orderId;
    private String orderName;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Order){
            return this.orderId == ((Order) obj).orderId && this.orderName.equals(((Order) obj).orderName);
        }
        return false;
    }
}
