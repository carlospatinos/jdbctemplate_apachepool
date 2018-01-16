package com.carlospatinos.dao;

import com.carlospatinos.vo.Configuracion;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class SimpleJDBCEmployeeDAOImpl extends JDBCEmployeeDAOImpl {

    public SimpleJDBCEmployeeDAOImpl(Configuracion config){
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUser(config.getUsuario());
        dataSource.setPassword(config.getPassword());
        dataSource.setURL(config.getUrl());
        this.setDataSource(dataSource);
    }
}
