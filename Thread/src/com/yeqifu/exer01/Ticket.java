package com.yeqifu.exer01;

/**
 * 三个线程同时开始卖票（存在线程安全问题）
 * WindowTicket02继承Thread类  WindowTicket类中的静态变量在多个线程中共享，普通变量不共享
 * @Author: 落亦-
 * @Date: 2020/2/17 12:37
 */
class WindowTicket extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+":"+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
public class Ticket {

    public static void main(String[] args) {
        WindowTicket windowTicket01 = new WindowTicket();
        WindowTicket windowTicket02 = new WindowTicket();
        WindowTicket windowTicket03 = new WindowTicket();
        windowTicket01.start();
        windowTicket02.start();
        windowTicket03.start();
    }
}
