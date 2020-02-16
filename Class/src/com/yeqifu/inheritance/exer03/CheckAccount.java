package com.yeqifu.inheritance.exer03;

/**
 * @Author: 落亦-
 * @Date: 2020/1/13 14:05
 */
public class CheckAccount extends Account {

    private double overdraft;

    public CheckAccount(int id, double balance, double annuallnterestRate,double overdraft) {
        super(id, balance, annuallnterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount){
        if (amount<getBalance()){
            System.out.println("取款成功，取出："+amount+"元");
            setBalance(getBalance()-amount);
        }
        if (amount>getBalance()){
            double overMoney;
            overMoney = amount-getBalance();
            if (overdraft>overMoney){
                setBalance(0);
                overdraft = overdraft - overMoney;
            }else {
                System.out.println("超过可透支限额！");
            }
        }
    }



}
