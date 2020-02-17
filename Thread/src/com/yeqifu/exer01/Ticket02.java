package com.yeqifu.exer01;

/**
 * 三个线程同时开始卖票（存在线程安全问题）
 * WindowTicket02实现Runnable接口  WindowTicket02类中的变量在多个线程中共享
 * @Author: 落亦-
 * @Date: 2020/2/17 13:08
 */
class WindowTicket02 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+":卖票"+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }

}
public class Ticket02 {
    public static void main(String[] args) {
        WindowTicket02 windowTicket02 = new WindowTicket02();
        Thread thread01 = new Thread(windowTicket02);
        Thread thread02 = new Thread(windowTicket02);
        Thread thread03 = new Thread(windowTicket02);
        thread01.start();
        thread02.start();
        thread03.start();

    }
}
