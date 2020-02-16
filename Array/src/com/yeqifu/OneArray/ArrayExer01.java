package com.yeqifu.OneArray;

/**
 * @Author: 落亦-
 * @Date: 2019/12/28 19:46
 */
public class ArrayExer01 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,5,8},{12,9},{7,0,6,4}};
        //声明和为0
        int sum = 0 ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum+=arr[i][j];
            }
        }
        System.out.println("所有元素的和为："+sum);

    }

}
