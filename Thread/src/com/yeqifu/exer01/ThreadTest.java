package com.yeqifu.exer01;

/**
 * 输出0-100之间的偶数
 * @Author: 落亦-
 * @Date: 2020/2/16 22:13
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest  {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 1000; i++) {
            if (i%2==0){
                System.out.println(i+"********main()*************");
            }
        }
    }
}
