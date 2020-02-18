package com.yeqifu.exer03;

/**
 * 线程A不断打印1-10的数字，打印到第5个数字时通知线程B
 * @Author: 落亦-
 * @Date: 2020/2/18 18:01
 */
class Sout implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (number <= 10) {
                    notify();
                    System.out.println(Thread.currentThread().getName() + "输出：" + number);
                    number++;
                    try {
                        if (number>5){
                            wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}
public class SoutTest {

    public static void main(String[] args) {
        Sout sout = new Sout();
        Thread soutTest01 = new Thread(sout);
        Thread soutTest02 = new Thread(sout);
        soutTest01.setName("线程A");
        soutTest02.setName("线程B");
        soutTest01.start();
        soutTest02.start();
    }
}
