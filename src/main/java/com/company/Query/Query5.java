package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//add new author
public class Query5 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new author firstname");
            String authorFirstName = scanner.nextLine();
            System.out.println("Enter new author lastname");
            String authorLastName = scanner.nextLine();
            String authorQuery = "INSERT INTO authors (firstName, lastName) " +
                                "VALUES ('" + authorFirstName +"', '" + authorLastName +"');";
            stmt.executeUpdate(authorQuery);
            System.out.println("New author added");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
