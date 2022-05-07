package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//add new publisher
public class Query2 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new publisher");
            String newPublisher = scanner.nextLine();
            String queryNewPublisher = "INSERT INTO publishers (publisherName)" +
                                    "VALUES ('" + newPublisher + "');";
            stmt.executeUpdate(queryNewPublisher);
            System.out.println("new publisher added");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
