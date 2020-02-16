package com.yeqifu.service;

import com.yeqifu.domain.*;

/**
 * 负责将Data中的数据封装到Employee[]
 * @Author: 落亦-
 * @Date: 2020/2/15 20:27
 */
public class NameListService {
    private Employee[] employees;

    /**
     * 给employees及数组元素进行初始化
     */
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            //获取员工类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            //获取Employee的4个基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type){
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
                    default:
            }
        }
    }

    /**
     * 获取指定index上的员工的设备
     * @param index
     * @return
     */
    private Equipment createEquipment(int index) {
        //获取设备类型
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        switch (type){
            case Data.PC:
                return new PC(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQUIPMENTS[index][1],Double.parseDouble(Data.EQUIPMENTS[index][2]));
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);
                default:
        }
        return null;
    }

    /**
     * 获得所有员工
     * @return
     */
    public Employee[] getAllEmployees(){
        return employees;
    }

    /**
     * 获得一个员工
     * @param id    员工ID
     * @return      该员工实体类
     * @throws TeamException
     */
    public Employee getEmployee(Integer id) throws TeamException{
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId().equals(id)){
                return employees[i];
            }
        }
        throw new TeamException("找不到员工");
    }



}
