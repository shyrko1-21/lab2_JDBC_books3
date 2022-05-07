package com.company.TestOfTables;


import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertTestData {
    public static void main(String[] args) {
        updateTables();
    }
    public static void updateTables() {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updateAuthorsTable(stmt);
            updateAuthorIsbnTable(stmt);
            updateTitlesTable(stmt);
            updatePublishersTable(stmt);
            JDBC.close();
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            return;
        }
    }

    public static void updateAuthorsTable(Statement stmt) {
        String authorFirstNames[] = { "Jane", "Dan", "Ralph Waldo", "F.Scott","John", "Ernest", "Walter", "Stephen", "Stieg",
                "George", "Joanne K.", "John", "John R. R.", "Kurt", "Andy" };
        String authorLastNames[] = { "Austen", "Brown", "Emerson", "Firtzgerald", "Grisham", "Hemingway", "Isaacson",
                "King", "Larsson", "Orwell", "Rowling", "Steinbeck", "Tolkien", "Vonnegut", "Weir" };
        // reset the auto increment
        String updateAuthorsTable = "ALTER TABLE Authors AUTO_INCREMENT = 1";
        try {
            stmt.executeUpdate(updateAuthorsTable);
        } catch (SQLException e) {
            System.out.println("Execute update failed");
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < authorFirstNames.length; i++) {
            updateAuthorsTable = "INSERT INTO Authors (firstName, lastName) " +
                                "VALUES ('" + authorFirstNames[i] + "', '" +
                                authorLastNames[i] + "');";
            try {
                stmt.executeUpdate(updateAuthorsTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

    private static void updateAuthorIsbnTable(Statement stmt) {
        String isbn[] = { "0141439518", "0307474278", "0142437629", "0743273565", "0345543240", "0684801223",
                "1501127625", "1501175466", "0307949486", "0451524935", "0439708180", "0142000687", "0547928227",
                "0385333849", "0553418026" };
        for (int i = 1; i <= isbn.length; i++) {
            String updateAuthorISBNTable = "INSERT INTO authorISBN (authorID, isbn)" + "VALUES (" + i + ", '"
                    + isbn[i - 1] + "')";
            try {
                stmt.executeUpdate(updateAuthorISBNTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

    private static void updateTitlesTable(Statement stmt) {
        String isbn[] = {"0141439518", "0307474278", "0142437629", "0743273565", "0345543240", "0684801223",
                "1501127625", "1501175466", "0307949486", "0451524935", "0439708180", "0142000687", "0547928227",
                "0385333849", "0553418026"};
        String editionNumber[] = {"10", "10", "8", "4", "5", "7", "3", "14", "5", "3", "1", "18", "12", "2", "3"};
        String year[] = {"2002", "2009", "2003", "2004", "2014", "1995", "2015", "2017", "2011", "1961", "1999",
                "2002", "2012", "1999", "2014"};
        String publisherID[] = {"1", "2", "1", "3", "4", "3", "5", "3", "6", "7", "8", "1", "9", "10", "11"};
        String price[] = {"8.00", "8.99", "13.58", "6.99", "8.49", "9.98", "11.99", "9.55", "8.60", "7.64", "7.47",
                "13.60", "11.16", "12.51", "10.76"};
        String title[] = {"Pride and Prejudice", "The Da Vinci Code", "Nature and Selected Essays", "The Great Gatsby",
                "Sycamore Row", "The Old Man and The Sea", "Steve Jobs", "It: A Novel",
                "The Girl with the Dragon Tattoo", "1984", "Harry Potter and the Sorcerer''s Stone", "Cannery Row",
                "The Hobbit", "Slaughterhouse-Five", "The Martian"};
        for (int i = 0; i < isbn.length; i++) {
            String updateTitlesTable = "INSERT INTO Titles (isbn, title, editionNumber, year, publisherID, price)"
                    + "VALUES ('" + isbn[i] + "', '" + title[i] + "', " + editionNumber[i] + ",'" + year[i] + "',"
                    + publisherID[i] + "," + price[i] + ")";
            try {
                stmt.executeUpdate(updateTitlesTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

    public static void updatePublishersTable(Statement stmt) {
        String publisherNames[] = { "NY Pub", "London Pub", "Moscow Pub"};
        // reset the auto increment
        String updatePublisherTable = "ALTER TABLE publishers AUTO_INCREMENT = 1";
        try {
            stmt.executeUpdate(updatePublisherTable);
        } catch (SQLException e) {
            System.out.println("Execute update failed");
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < publisherNames.length; i++) {
            updatePublisherTable = "INSERT INTO publishers (publisherName) " +
                    "VALUES ('" + publisherNames[i] + "')";
            try {
                stmt.executeUpdate(updatePublisherTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }
}
