package com.yeqifu.view;

import com.yeqifu.domain.Customer;
import com.yeqifu.service.CustomerList;
import com.yeqifu.util.CMUtility;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户的操作
 * @Author: 落亦-
 * @Date: 2020/1/10 11:52
 */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        /*Customer cust = new Customer("luoyi",'男',20,"15279230588","1784525940@qq.com");
        customerList.addCustomer(cust);*/
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

    /**
     * 进入主界面的方法
     */
    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("============客户信息管理软件=============");
            System.out.println("              1.添加客户                ");
            System.out.println("              2.修改客户                ");
            System.out.println("              3.删除客户                ");
            System.out.println("              4.客户列表                ");
            System.out.println("              5.退   出                 ");
            System.out.print("            请选择(1-5):");
            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }
                default:
            }
        }
    }

    /**
     * 添加一个客户
     */
    public void addCustomer(){
        System.out.println("=====================添加客户===================");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char sex = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String telphone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(25);
        //将上述数据封装到对象中
        Customer customer = new Customer(name,sex,age,telphone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess){
            System.out.println("=====================添加客户成功===================");
        }else {
            System.out.println("=================客户目录已满添加失败================");
        }
    }

    /**
     * 修改一个客户
     */
    public void modifyCustomer(){
        System.out.println("=====================修改客户===================");
        Customer oneCustomer;
        int num;
        for (;;){
            System.out.print("请选择待修改客户编号(-1退出):");
            num = CMUtility.readInt();
            if (num == -1){
                return;
            }

            oneCustomer = customerList.getOneCustomer(num - 1);
            if (oneCustomer == null){
                System.out.println("无法找到指定的客户！");
            }else {
                //找到了相应的编号客户
                break;
            }
        }
        //修改客户信息
        System.out.print("姓名("+oneCustomer.getName()+"):");
        String name = CMUtility.readString(10,oneCustomer.getName());
        System.out.print("性别("+oneCustomer.getSex()+"):");
        char sex = CMUtility.readChar(oneCustomer.getSex());

        System.out.print("年龄("+oneCustomer.getAge()+"):");
        int age = CMUtility.readInt(oneCustomer.getAge());

        System.out.print("电话("+oneCustomer.getTelphone()+"):");
        String telphone = CMUtility.readString(13,oneCustomer.getTelphone());
        System.out.print("邮箱("+oneCustomer.getEmail()+"):");
        String email = CMUtility.readString(25,oneCustomer.getEmail());

        oneCustomer.setName(name);
        oneCustomer.setSex(sex);
        oneCustomer.setAge(age);
        oneCustomer.setTelphone(telphone);
        oneCustomer.setEmail(email);

        boolean isSuccess = customerList.replaceCustomer(num - 1, oneCustomer);
        if (isSuccess){
            System.out.println("===================修改客户成功=================");
        }else {
            System.out.println("===============客户编号有误,找不到此客户===============");
        }


    }

    /**
     * 删除一个客户
     */
    public void deleteCustomer(){
        System.out.println("=====================删除客户===================");
        Customer oneCustomer;
        int num;
        for (;;){
            System.out.print("请选择待删除的客户编号(-1退出):");
            num = CMUtility.readInt();
            if (num == -1){
                return;
            }

            oneCustomer = customerList.getOneCustomer(num - 1);
            if (oneCustomer == null){
                System.out.println("无法找到指定的客户！");
            }else {
                //找到了相应的编号客户
                break;
            }
        }

        //进行删除
        System.out.print("确认是否删除(Y/N):");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y'){
            boolean isSuccess = customerList.deleteCustomer(num - 1);
            if (isSuccess){
                System.out.println("=====================删除客户成功===================");
            }else {
                System.out.println("=====================删除客户失败===================");
            }
        }else {
            return;
        }

    }

    /**
     * 展示一个客户的列表
     */
    public void listAllCustomer(){
        System.out.println("=====================客户列表===================");
        Customer[] allCustomer = customerList.getAllCustomer();
        if (allCustomer.length<=0){
            System.out.println("没有数据！");
        }else {
            System.out.println("编号\t\t姓名\t\t\t性别\t\t\t年龄\t\t\t电话\t\t\t\t邮箱");
            for (int i = 0; i <allCustomer.length; i++) {
                System.out.println(i+1+"\t\t"+allCustomer[i].getName()+"\t\t"+allCustomer[i].getSex()+"\t\t\t"+allCustomer[i].getAge()+"\t\t\t"+allCustomer[i].getTelphone()+"\t\t"+allCustomer[i].getEmail());
            }
        }
        System.out.println("=====================客户列表展示结束===================");
    }



}

