package com.yeqifu.exercise;

/**
 * @Author: 落亦-
 * @Date: 2020/1/9 13:08
 */
public class AccountCustomerBankTest02 {
    public static void main(String[] args) {
        Customers customers = new Customers("斯嘉丽","约翰逊");

        Accounts accounts = new Accounts(5000);

        customers.setAccounts(accounts);

        Bank bank = new Bank();

        bank.addCustomer(customers.getFirstName(),customers.getLastName());

        int numOfCustomers = bank.getNumOfCustomers();
        System.out.println("银行有 "+numOfCustomers+" 个客户");

        Customers customers1 = bank.getCustomers(0);
        System.out.println(customers1.getFirstName()+customers1.getLastName());


    }

}

class Accounts{
    private double balance;

    public Accounts(double init_balance){
        this.balance = init_balance;
    }

    public double getBalance(){
        return balance;
    }

    /**
     * 存钱
     * @param amt
     */
    public void deposit(double amt){
        if (amt>0){
            this.balance = this.balance+amt;
            System.out.println("存钱成功");
        }
    }

    /**
     * 取钱
     * @param amt
     */
    public void withdraw(double amt){
        if (balance<amt){
            System.out.println("账号的余额不足！"+"账户余额为："+this.balance);
        }else {
            this.balance = this.balance-amt;
            System.out.println("成功取出："+amt);
        }
    }

}

class Customers{
    private String firstName;
    private String lastName;
    private Accounts accounts;

    public Customers(String f,String l){
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Accounts getAccounts(){
        return accounts;
    }

    public void setAccounts(Accounts accounts){
        this.accounts = accounts;
    }
}

class Bank{
    private Customers[] customers;
    private int numberOfCustomers;

    public Bank(){
        customers = new Customers[10];
    }

    /**
     * 添加客户
     * @param f     客户的名
     * @param l     客户的姓
     */
    public void addCustomer(String f,String l){
        Customers cust = new Customers(f,l);
        customers[numberOfCustomers] = cust;
        numberOfCustomers++;
    }

    //获取客户的个数
    public int getNumOfCustomers(){
        return numberOfCustomers;
    }

    //获取指定位置上的客户
    public Customers getCustomers(int index){
        if (index>=0&&index<numberOfCustomers){
            return customers[index];
        }
        return null;
    }

}