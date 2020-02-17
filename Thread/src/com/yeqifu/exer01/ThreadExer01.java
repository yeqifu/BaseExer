package com.yeqifu.exer01;

/**
 * 创建两个分线程，其中一个计算100以内的奇数，另一个计算100以内的偶数
 * @Author: 落亦-
 * @Date: 2020/2/17 9:36
 */
class JiNum extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+"  JiNum"+i);
            }
        }
    }
}
class OuNum extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"  OuNum"+i);
            }
        }

    }
}

public class ThreadExer01 {

    public static void main(String[] args) {
        JiNum jiNum = new JiNum();
        jiNum.start();
//        jiNum.start();
        OuNum ouNum = new OuNum();
        ouNum.start();
        //创建Thread类的匿名子类 启动线程
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("******"+i+"*************");
                }
            }
        }.start();
    }

}
