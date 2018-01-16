package com.carlospatinos.dao;

import com.carlospatinos.vo.Employee;

public interface JDBCEmployeeDAO {
    public void insert(Employee employee);
    public Employee findById(int id);
}
