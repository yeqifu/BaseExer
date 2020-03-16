package com.yeqifu.exer06.dao;

import com.yeqifu.exer06.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/3/16 19:00
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

    @Override
    public void insert(Connection connection, Customer customer) {
        String sql = "insert into customers (name,email,birth) values (?,?,?)";
        update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth());
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth(),customer.getId());
    }

    @Override
    public void deleteById(Connection connection, Integer id) {
        String sql = "delete from customers where id = ?";
        update(connection,sql,id);
    }

    @Override
    public Customer getCustomerById(Connection connection, Integer id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = getInstance(connection, Customer.class, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getCustomerList(Connection connection) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> customerList = getForList(connection,Customer.class,sql);
        return customerList;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        return getValue(connection,sql);
    }
}
