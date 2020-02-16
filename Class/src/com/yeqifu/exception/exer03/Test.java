package com.yeqifu.exception.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/2/16 11:24
 */
public class Test{
    public static void main(String[] args){
        try{
            int[] arr = {1,1,1,1};
            for(int i = 0;i < 5; i++){
                System.out.println(arr[i]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }finally {
            System.out.println("这是一个异常，不是错误！");
        }
    }
}

