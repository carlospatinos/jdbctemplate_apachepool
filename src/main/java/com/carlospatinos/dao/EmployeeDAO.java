package com.carlospatinos.dao;

import com.carlospatinos.vo.Employee;

public interface EmployeeDAO {
    public void insert(Employee employee);
    public Employee findById(int id);
}
