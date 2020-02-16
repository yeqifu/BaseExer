package com.yeqifu.exercise;

/**
 * @Author: 落亦-
 * @Date: 2020/1/9 10:44
 */
public class AccountCustomerTest01 {

    public static void main(String[] args) {
        Customer customer = new Customer("Jane","Smith");

        Account account = new Account(1000,2000,0.0123);
        customer.setAccount(account);

        customer.getAccount().deposit(100);
        customer.getAccount().withdraw(960);
        customer.getAccount().withdraw(2000);

    }

}

class Account{
    private int id;
    private double balance;
    private double annuallnterestRate;

    public Account(int id,double balance,double annuallnterestRate){
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

    public void withdraw(double amount){

        if (this.balance-amount<0){
            System.out.println("Customer " +" has a account: id is"+this.getId()+",annuallnterestRate is "+this.getAnnuallnterestRate()+"账号的余额不足！"+"账户余额为："+this.balance);
        }else {
            this.balance = this.balance-amount;
            System.out.println("成功取出："+amount);
        }
    }

    public void deposit(double amount){
        this.balance = this.balance+amount;
        System.out.println("成功存入"+amount);
    }
}

class Customer{
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f,String l){
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
