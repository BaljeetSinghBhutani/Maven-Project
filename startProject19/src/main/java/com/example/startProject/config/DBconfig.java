package com.example.startProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBconfig {
    @Bean
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl34", "root","ayan@123" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
