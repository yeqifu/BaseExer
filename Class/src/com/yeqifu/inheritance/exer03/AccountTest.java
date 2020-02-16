package com.yeqifu.inheritance.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/1/13 14:01
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122,20000,0.045);
        account.withdraw(30000);
        account.withdraw(2500);
        account.deposit(3000);
    }
}
