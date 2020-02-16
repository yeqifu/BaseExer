package com.yeqifu.TwoArray;

/**
 * @Author: 落亦-
 * @Date: 2019/12/29 15:09
 */
public class ArrayExer02_true {

    public static void main(String[] args) {

        //1.动态初始化一个二维数组
        int[][] yanHui = new int[10][];
        //2.将yanHui[i][i]和yanHui[i][0]都赋初值为1
        for (int i = 0; i < yanHui.length; i++) {
            yanHui[i] = new int[i+1];
            yanHui[i][i] = 1;
            yanHui[i][0] = 1;
            if (i>1){
                for (int j = 1; j < yanHui[i].length-1; j++) {
                    yanHui[i][j] = yanHui[i-1][j]+yanHui[i-1][j-1];
                }

            }
        }

        for (int i = 0; i < yanHui.length; i++) {
            for (int j = 0; j < yanHui[i].length; j++) {
                System.out.print(yanHui[i][j]+"\t");
            }
            System.out.println();
        }



    }


}
