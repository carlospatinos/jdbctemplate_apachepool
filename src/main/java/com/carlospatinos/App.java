package com.carlospatinos;

import com.carlospatinos.dao.EmployeeDAO;
import com.carlospatinos.dao.JDBCEmployeeDAO;
import com.carlospatinos.dao.JDBCEmployeeDAOImpl;
import com.carlospatinos.vo.Employee;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class App {

    public static void main(String[] args) {

        BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName("com.mysql.jdbc.Driver");
		dbcp.setUsername("user");
		dbcp.setPassword("user");
        dbcp.setUrl("jdbc:mysql://172.17.0.2:3306/test_schema");
        //JdbcTemplate jdbcTemplateMySqlPool = new JdbcTemplate(dbcp);

/*
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUser("user");
        dataSource.setPassword("user");
        dataSource.setServerName("172.17.0.2");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("test_schema");
        //JdbcTemplate jdbcTemplateMySql = new JdbcTemplate(dataSource);
*/
        JDBCEmployeeDAOImpl jdbcEmployeeDAO = new JDBCEmployeeDAOImpl();
        jdbcEmployeeDAO.setDataSource(dbcp);

        Employee employee3 = new Employee(458, "Carlos JDBC Template", 34);
        jdbcEmployeeDAO.insert(employee3);

        Employee employee4 = jdbcEmployeeDAO.findById(458);
        System.out.println(employee4);

        /*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
        Employee employee1 = new Employee(123, "Carlos DAO", 30);
        employeeDAO.insert(employee1);

        Employee employee2 = employeeDAO.findById(123);
        System.out.println(employee2);
        context.close();*/

        /*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JDBCEmployeeDAO jdbcEmployeeDAO = (JDBCEmployeeDAO) context.getBean("jdbcEmployeeDAO");
        Employee employee3 = new Employee(456, "Carlos JDBC Template", 34);
        jdbcEmployeeDAO.insert(employee3);

        Employee employee4 = jdbcEmployeeDAO.findById(456);
        System.out.println(employee4);
        context.close();
        */
    }
}
