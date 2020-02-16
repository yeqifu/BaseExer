package com.yeqifu.inheritance.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/1/13 13:53
 */
public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    /**
     * 返回月利率
     * @return
     */
    public double getMonthlyInterest(){
        return getAnnuallnterestRate()/12;
    }

    /**
     * 取款
     * @param amount    需要取的钱
     */
    public void withdraw(double amount){
        if (balance<amount){
            System.out.println("您的账户余额不足");
            System.out.println("您的账户余额为："+balance);
        }else {
            balance = balance-amount;
        }
    }

    /**
     * 存款
     * @param amount    需要存的钱
     */
    public void deposit(double amount){
        balance = balance+amount;
        System.out.println("您的账户余额为："+balance);
        System.out.println("月利率为："+getMonthlyInterest());
    }



}
