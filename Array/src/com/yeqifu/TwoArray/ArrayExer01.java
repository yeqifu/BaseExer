package com.yeqifu.TwoArray;

/**
 * 输出一个杨辉三角
 * @Author: 落亦-
 * @Date: 2019/12/28 20:06
 */
public class ArrayExer01 {

    public static void main(String[] args) {
        //1.动态初始化一个数组
        int[][] arr = new int[][]{{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1}};
        //2.让所有的元素都为1
       /* for (int i = 0; i < arr.length; i++) {
            arr[i][i]=1;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j-1]=1;
            }
        }*/

       /* for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }*/
        //3.第N行有N个元素
        for (int i = 0; i < arr.length; i++) {
            for (int j = i-1; j < i+1; j++) {
                if (i>1&&i<(arr.length+1)&&(j>0&&j<i+1)){
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
