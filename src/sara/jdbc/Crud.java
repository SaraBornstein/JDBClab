package sara.jdbc;

import java.sql.*;

public class Crud {

    private static Statement statement;
    private static Connection connection;
    private static ResultSet resultSet;
/*
    public static void addBook() throws SQLException {
        statement.executeUpdate("INSERT INTO JDBClab.to_be_read (title, author, pages) VALUES ('Some Title', 'Some Author', 4)");
    }

    public static void queryRecords() throws SQLException {

        // Statements allow to issue SQL queries to the database
        statement = connection.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement
                .executeQuery("select * from JDBClab.to_be_read");

        // loop through the result set while there are more records
        while (resultSet.next()) {

            // get the id, name and units fields from the result set and assign them to local variables
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            int pages = resultSet.getInt("pages");

            // print out the result
            System.out.println("Book: " + title + " by " + author + " is " + pages + " pages");
        }
    }

    public static void updateRecord(){

        statement = connection.createStatement();
        // the variable "x" below will contain the number of rows affected by the query
        int x = statement.executeUpdate("UPDATE JDBClab.to_be_read set pages = 500 where id = 6");

    }

    public static void deleteRecord(){

        statement = connection.createStatement();
        // the variable "x" below will contain the number of rows affected by the query
        int x = statement.executeUpdate("DELETE from JDBClab.to_be_read where id = 6");

    }

    public static void mapResultSet(){

    }
 */

}
