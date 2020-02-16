package com.yeqifu.service;

import com.yeqifu.domain.Customer;

/**
 * CustomerList为Customer对象的管理模块
 * 内部使用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 * @Author: 落亦-
 * @Date: 2020/1/10 11:52
 */
public class CustomerList {

    /**
     * customers为存放客户的数组
     */
    private Customer[] customers;
    /**
     * total为已保存客户的数量
     */
    private int total;

    /**
     * 用来初始化数组的构造器
     * @param totalCustomer     初始化数组的大小
     */
    public CustomerList(int totalCustomer){
        //初始化数组的大小为totalCustomers
        customers = new Customer[totalCustomer];
    }

    /**
     * 判断数组是否已满
     * @return  true:数组已满   false:数组未满
     */
    private boolean ifFull(){
        if (customers.length>total){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 添加一个客户
     * @param customer  需要添加的客户
     * @return  true:添加成功   false:添加失败
     */
    public boolean addCustomer(Customer customer){
        if (!ifFull()){
            customers[total] = customer;
            total++;
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新一个客户
     * @param index     需要更新的客户的索引
     * @param cust      需要更新的客户
     * @return      true:更新成功   false:更新失败
     */
    public boolean replaceCustomer(int index,Customer cust){
        if (index<0&&index>=total){
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定索引的客户
     * @param index     需要删除的客户的索引
     * @return      true:删除成功   false:删除失败
     */
    public boolean deleteCustomer(int index){
        if (index<0&&index>=total){
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i+1];
        }
        //最后一个元素置为null
        customers[total-1] = null;
        total--;
        return true;
    }

    /**
     * 得到所有客户
     * @return      返回一个存储所有客户的数组
     */
    public Customer[] getAllCustomer(){
         Customer[] allCustomer = new Customer[total];
        for (int i = 0; i < total; i++) {
            allCustomer[i] = customers[i];
        }
        return allCustomer;
    }

    /**
     * 得到一个客户
     * @param index     要查询客户的索引
     * @return      返回该索引上的客户或者返回null
     */
    public Customer getOneCustomer(int index){
        if (index<0||index>=total){
            return null;
        }
        return customers[index];
    }

    /**
     * 得到客户的总数
     * @return  客户的总数
     */
    public int getTotal(){
        return total;
    }

}
