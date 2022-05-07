package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//list of books of the author
public class Query4 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            System.out.println("Enter author id");
            Scanner scanner = new Scanner(System.in);
            int authorId = scanner.nextInt();
            String booksQuery = "SELECT * FROM authorisbn " +
                    "WHERE authorId = " + authorId + ";";
            ResultSet rs = stmt.executeQuery(booksQuery);
            System.out.println("AuthorID " + authorId + " books:");
            while (rs.next()) {
                authorId = rs.getInt("authorId");
                String isbn = rs.getString("isbn");
                System.out.println(authorId + "\t" + isbn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

}
