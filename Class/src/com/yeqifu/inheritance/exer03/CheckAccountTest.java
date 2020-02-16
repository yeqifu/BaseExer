package com.yeqifu.inheritance.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/1/13 14:15
 */
public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1122,20000,0.045,5000);
        checkAccount.withdraw(5000);
        System.out.println("您的账户余额为："+checkAccount.getBalance());
        System.out.println("您的可透支额："+checkAccount.getOverdraft());

        checkAccount.withdraw(18000);
        System.out.println("您的账户余额为："+checkAccount.getBalance());
        System.out.println("您的可透支额："+checkAccount.getOverdraft());

        checkAccount.withdraw(3000);
        System.out.println("您的账户余额为："+checkAccount.getBalance());
        System.out.println("您的可透支额："+checkAccount.getOverdraft());
    }
}
