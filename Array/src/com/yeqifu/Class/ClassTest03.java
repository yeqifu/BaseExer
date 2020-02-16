package com.yeqifu.Class;

/**
 * @Author: 落亦-
 * @Date: 2020/1/2 8:17
 */
public class ClassTest03 {

    public static void main(String[] args) {

        ClassTest03 test03 = new ClassTest03();
        int area = test03.method(10,8);
        System.out.println("矩形的面积是:"+area);

    }

    public int method(int m,int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        int area = m*n;

        return area;

    }

}


