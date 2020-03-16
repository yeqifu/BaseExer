package com.yeqifu.exer06.dao;

import com.yeqifu.exer06.entity.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/3/16 18:49
 */
public interface CustomerDao {

    /**
     * 插入一条记录
     * @param connection
     */
    public void insert(Connection connection,Customer customer);

    /**
     * 更新一条记录
     * @param connection
     */
    public void update(Connection connection,Customer customer);

    /**
     * 删除一条记录
     * @param connection
     * @param id
     */
    public void deleteById(Connection connection,Integer id);

    /**
     * 查询一条记录
     * @param connection
     * @param id
     * @return
     */
    public Customer getCustomerById(Connection connection,Integer id);

    /**
     * 查询多条记录
     * @param connection
     * @return
     */
    public List<Customer> getCustomerList(Connection connection);

    /**
     * 返回数据表中数据的条目数
     * @param connection
     * @return
     */
    public Long getCount(Connection connection);

}
