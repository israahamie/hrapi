package com.example.hrapi;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is the driver class which runs the entire application
 * a connection is established to the database in this class
 */
@SpringBootApplication
public class HrApiApplication {

    public static SqlSessionFactory sql;
    Connection dbConnection;

    {
        try {//url,user,password
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hr", "postgres", "jarvis23");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HrApiApplication.class, args);
    }

}
