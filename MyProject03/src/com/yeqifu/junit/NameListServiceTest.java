package com.yeqifu.junit;

import com.yeqifu.domain.Employee;
import com.yeqifu.service.NameListService;
import com.yeqifu.service.TeamException;
import org.junit.Test;

/**
 * @Author: 落亦-
 * @Date: 2020/2/16 14:10
 */
public class NameListServiceTest {


    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployees(){
        NameListService nameListService = new NameListService();
        Employee employee = null;
        try {
            employee = nameListService.getEmployee(30);
        } catch (TeamException e) {
            System.out.println(e.getMessage());

        }
    }


}
