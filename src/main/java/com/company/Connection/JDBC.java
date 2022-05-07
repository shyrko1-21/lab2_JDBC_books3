package com.company.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class JDBC {
    public static Connection connection = null;
    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("MySQL JDBC Driver registered");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySql driver?");
            e.printStackTrace();
            throw new SQLException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books3", "root", "root");

        connection = DriverManager.getConnection("jdbc:mysql://localhost/books3?useUnicode=true&serverTimezone=UTC", "root", "root");

        if (connection == null) {
            throw new SQLException();
        } else {
            System.out.println("Successfully connected");
        }
    }
    public static void close(){
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection");
        }
    }
}
