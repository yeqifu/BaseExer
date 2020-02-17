package com.yeqifu.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/2/17 18:55
 */
class TicketSecurityRunnable implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        synchronized(obj) {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "窗口：票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class TicketSecurity {
    public static void main(String[] args) {
        TicketSecurityRunnable ticketSecurityRunnable = new TicketSecurityRunnable();
        Thread test01 = new Thread(ticketSecurityRunnable);
        Thread test02 = new Thread(ticketSecurityRunnable);
        Thread test03 = new Thread(ticketSecurityRunnable);

        test01.setName("窗口一");
        test02.setName("窗口二");
        test03.setName("窗口三");

        test01.start();
        test02.start();
        test03.start();

    }
}
