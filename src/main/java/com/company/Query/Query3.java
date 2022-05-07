package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//show publishers, change name
public class Query3 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String publishersQuery = "SELECT * FROM publishers;";
            System.out.println("List of publishers: ");
            ResultSet rs = stmt.executeQuery(publishersQuery);
            int count = 0;
            while (rs.next()) {
                int id = rs.getInt("publisherID");
                String publisherName = rs.getString("publisherName");
                System.out.println(id + "\t" + publisherName);
                count++;
            }
            System.out.println("Enter publisher id to change name");
            Scanner scanner = new Scanner(System.in);
            int id = Integer.parseInt(scanner.nextLine());
            if (id <= count) {
                System.out.println("Enter new publisher name");
                String newName = scanner.nextLine();
                publishersQuery = "UPDATE publishers " +
                        "SET publisherName = '" + newName +"'" +
                        "WHERE publisherID = " + id + ";";
                stmt.executeUpdate(publishersQuery);
                System.out.println("Publisher " + id + " changed");
            } else  System.out.println("id doesn't exist");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
