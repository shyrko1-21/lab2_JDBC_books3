package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//show all authors sort by firstname, lastname
public class Query1 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query1Author = "SELECT * FROM authors " +
                        "ORDER BY firstName, lastName;";
            System.out.println("show all authors sort by firstname, lastname");
            ResultSet rs1 = stmt.executeQuery(query1Author);
            while (rs1.next()) {
                int id = rs1.getInt("authorId");
                String firstName = rs1.getString("firstname");
                String lastname = rs1.getString("lastname");
                System.out.println(id + "\t" + firstName + "\t" + lastname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
