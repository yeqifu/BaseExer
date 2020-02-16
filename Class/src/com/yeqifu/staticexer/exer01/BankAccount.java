package com.yeqifu.staticexer.exer01;

/**
 * @Author: 落亦-
 * @Date: 2020/1/16 21:37
 */
public class BankAccount {
    private int accountNum;
    private String password;
    private double balance;
    public static double interestRate;
    public static double minBalance;

    public BankAccount(int accountNum, String password, double balance) {
        this.accountNum = accountNum;
        this.password = password;
        this.balance = balance;
    }



}
