package com.yeqifu.method;

/**
 * @Author: 落亦-
 * @Date: 2020/1/2 17:38
 */
public class OverloadTest02 {

    public static void main(String[] args) {

    }

    /**
     * 求两个数的最大值
     * @param num1
     * @param num2
     * @return
     */
    public int max(int num1,int num2){
        int max = num1;
        if (num2>max){
            int temp;
            temp = max;
            max = num2;
            num2 = temp;
        }
        return max;
    }

    public double max(double num1,double num2){
        double max = num1;
        if (num2>max){
            double temp;
            temp = max;
            max = num2;
            num2 = temp;
        }
        return max;
    }

    public double max(double num1,double num2,double num3){
        double max = num1;
        if (max<num2){
            double temp;
            temp = max;
            max = num2;
            num2 = temp;
        }else if (max<num3){
            double temp;
            temp = max;
            max = num3;
            num3 = temp;
        }
        return max;
    }


}
