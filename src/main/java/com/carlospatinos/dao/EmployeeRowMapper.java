package com.carlospatinos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.carlospatinos.vo.Employee;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class EmployeeRowMapper implements RowMapper	{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("CUST_ID"));
        employee.setName(rs.getString("NAME"));
        employee.setAge(rs.getInt("AGE"));
        return employee;
    }
}