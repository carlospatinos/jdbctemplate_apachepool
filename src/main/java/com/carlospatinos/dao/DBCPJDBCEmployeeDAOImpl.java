package com.carlospatinos.dao;

import com.carlospatinos.vo.Configuracion;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class DBCPJDBCEmployeeDAOImpl extends JDBCEmployeeDAOImpl {

    public DBCPJDBCEmployeeDAOImpl(Configuracion config){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername(config.getUsuario());
        dataSource.setPassword(config.getPassword());
        dataSource.setUrl(config.getUrl());
        this.setDataSource(dataSource);
    }
}
