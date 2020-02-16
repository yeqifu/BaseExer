package com.yeqifu.TwoArray;

/**
 * 输出一个杨辉三角
 * @Author: 落亦-
 * @Date: 2019/12/28 22:20
 */
public class ArrayExer02 {

    public static void main(String[] args) {
        //1.动态初始化一个二维数组
        int[][] arr = new int[10][10];
        //2.给数组赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i][i]=1;
            if (i>0){
                for (int j = 0; j < i; j++) {
                    arr[i][j]=1;
                }
            }
        }
        //3.从第三行开始，去除首尾，中间的每个数等于其上面的数以及上面的数的左边的数之和
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i+1; j++) {
                arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }


    }

}
