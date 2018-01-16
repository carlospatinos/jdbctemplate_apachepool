package com.carlospatinos;

import com.carlospatinos.dao.*;
import com.carlospatinos.execution.InsertTask;
import com.carlospatinos.vo.Configuracion;
import com.carlospatinos.vo.Employee;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class App {

    private static final int MAX_NUM_EMPLOYEES = 20;
    private static final int MAX_NUM_THREADS = 3;
    private static final int WAIT_TIME = 100;

    public static void main(String[] args) {
        Configuracion config = new Configuracion();
        config.setUsuario("user");
        config.setPassword("user");
        config.setUrl("jdbc:mysql://172.17.0.2:3306/test_schema");


        JDBCEmployeeDAO dao = new SimpleJDBCEmployeeDAOImpl(config);
        //JDBCEmployeeDAO dao = new DBCPJDBCEmployeeDAOImpl(config);


        List<Employee> employees = new ArrayList<>();
        for(int i=0; i <MAX_NUM_EMPLOYEES; i++){
            Employee employee = new Employee(i, "Random Name", i);
            employees.add(employee);
        }


        ExecutorService executor =  Executors.newFixedThreadPool(MAX_NUM_THREADS);

        Instant start = Instant.now();
        for (Employee emp: employees) {
            Runnable runner = new InsertTask(dao, emp);
            executor.execute(runner);
        }

        Instant end = Instant.now();
        System.out.println("Time taken in millis (" + MAX_NUM_THREADS + " threads for " + MAX_NUM_EMPLOYEES + " objects): " + Duration.between(start, end).toNanos());
        try {
            System.out.println("Waiting on thread");
            Thread.sleep(WAIT_TIME);
            executor.shutdown();
            System.out.println("Waiting on EF");
            executor.awaitTermination
                    (WAIT_TIME, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        System.exit(0);

    }
}
