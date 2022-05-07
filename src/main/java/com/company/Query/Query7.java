package com.company.Query;

import com.company.Connection.JDBC;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//add new publisher, titles, authorisbn
public class Query7 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new publisher");
            String newPublisher = scanner.nextLine();
            String newPublisherQuery = "INSERT INTO publishers (publisherName) " +
                                        "VALUES ('" + newPublisher + "');";
            stmt.executeUpdate(newPublisherQuery);
            System.out.println("New publisher added");
            System.out.println("Enter new book:");
            System.out.println("isbn:");
            String isbn = scanner.nextLine();
            System.out.println("title:");
            String title = scanner.nextLine();
            System.out.println("editionNumber:");
            int editionNumber = scanner.nextInt();
            System.out.println("year:");
            //?? не отрабатывает ввод даты, сразу publisher name:
            String year = scanner.nextLine();
            System.out.println("publisher name:");
            String publisherName = scanner.nextLine();
            System.out.println("price:");
            BigDecimal price = scanner.nextBigDecimal();
            String titlesQuery = "INSERT INTO titles VALUES(" +
                                "'" + isbn + "', " +
                                "'" + title + "', " +
                                editionNumber + ", " +
                                "'" + year + "', " +
                                "(SELECT publisherID from publishers where publisherName = '" + publisherName + "'), " +
                                price + ");";
            stmt.executeUpdate(titlesQuery);
            System.out.println("New book added");
            System.out.println("Enter new authorISBN:");
            System.out.println("author firstName ");
            String authorFirstName = scanner.nextLine();
            System.out.println("author lastName:");
            String authorLastName = scanner.nextLine();
            System.out.println("isbn:");
            String authorisbn = scanner.nextLine();

            String authorISBNQuery = "INSERT INTO authorisbn VALUES(" +
                                    "(SELECT authorID FROM authors WHERE firstName = '" + authorFirstName + "' AND " +
                                    "lastName = '" + authorLastName + "'), " +
                                    "'" + authorisbn + "');";
            stmt.executeUpdate(authorISBNQuery);
            System.out.println("New authorISBN added");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
