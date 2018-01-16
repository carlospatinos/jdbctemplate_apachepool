package com.carlospatinos.execution;

import com.carlospatinos.dao.DBCPJDBCEmployeeDAOImpl;
import com.carlospatinos.dao.JDBCEmployeeDAO;
import com.carlospatinos.vo.Configuracion;
import com.carlospatinos.vo.Employee;

public class InsertTask implements Runnable {
    private JDBCEmployeeDAO dao;
    private Employee employee;

    public InsertTask(JDBCEmployeeDAO dao, Employee employee){
        this.dao = dao;
        this.employee = employee;

    }
    public void run(){
        dao.insert(employee);
    }
}
