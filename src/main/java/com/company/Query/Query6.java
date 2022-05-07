package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//update author
public class Query6 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            System.out.println("Enter author ID");
            Scanner scanner = new Scanner(System.in);
            int authorId = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter author firstName");
            String firstName = scanner.nextLine();
            System.out.println("Enter author lastName");
            String lastName = scanner.nextLine();
            String authorQuery = "UPDATE authors " +
                            "SET firstName = '" + firstName +"', " +
                            "lastName = '" + lastName + "' " +
                            "WHERE authorId = " + authorId;
            stmt.executeUpdate(authorQuery);
            System.out.println("author changed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
