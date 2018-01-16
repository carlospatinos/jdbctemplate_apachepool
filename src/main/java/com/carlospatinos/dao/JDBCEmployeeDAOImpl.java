package com.carlospatinos.dao;

import javax.sql.DataSource;

import com.carlospatinos.vo.Employee;
import org.springframework.jdbc.core.JdbcTemplate;


public class JDBCEmployeeDAOImpl implements JDBCEmployeeDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Employee employee){

        String sql = "INSERT INTO Employee " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[] { employee.getId(),
                employee.getName(), employee.getAge()
        });
    }

    @SuppressWarnings({ "unchecked" })
    public Employee findById(int id){

        String sql = "SELECT * FROM Employee WHERE CUST_ID = ?";

        jdbcTemplate = new JdbcTemplate(dataSource);
        Employee employee = (Employee) jdbcTemplate.queryForObject(
                sql, new Object[] { id }, new EmployeeRowMapper());

        return employee;
    }
}
