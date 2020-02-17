package com.yeqifu.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/2/17 12:59
 */
class ThreadRunable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class Runnable01 {
    public static void main(String[] args) {
        ThreadRunable threadRunable  = new ThreadRunable();
        Thread thread01 = new Thread(threadRunable);
        Thread thread02 = new Thread(threadRunable);
        Thread thread03 = new Thread(threadRunable);
        thread01.setName("线程01");
        thread02.setName("线程02");
        thread03.setName("线程03");
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
