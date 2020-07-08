package sara.jdbc;

import java.sql.*;

import static sara.jdbc.Crud.*;

/**
 * JDBC Lab:
 * DONE Create a new MySQL database on your local machine (using MySQL Workbench)
 *       Create a single table within that database with at least 3 or 4 fields (workbench)
 *
 * Create a brand new Java application, from scratch (not in the labs project) - Create new project in IntelliJ
 * DONE Connect new project to Git Hub
 *       Within the new project, create a small application with CRUD (Create, Read, Update, Delete) functionality against the new DB
 *       Your code will need to be able to insert a new record, query that record, update that record, and delete that record
 *       Next insert several rows into the DB and demonstrate how to iterate over a ResultSet and “map” the DB results to an ArrayList of Java objects (the object will be a POJO with the same fields as the DB)
 *
 *       We want this application to be nicely organized and well structured.
 *       For instance, don’t do everything in one method. Break it up into a number of methods each with unique responsibilities -
 *       for instance, insertRecord()  and queryRecords()
 **/

public class JDBCLab {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/JDBClab?"
                            + "user=root&password= &useSSL=false");
            statement = connection.createStatement();

            //Insert new row
            //statement.executeUpdate("INSERT INTO JDBClab.to_be_read (title, author, pages) VALUES ('Some Title', 'Some Author', 4)");
            //Crud.addBook();

            //Update row
            //statement.executeUpdate("UPDATE JDBClab.to_be_read set pages = 500 where id = 6");

            //Delete row
            //statement.executeUpdate("DELETE from JDBClab.to_be_read where id = 6");

            /*
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
*/

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Exception occured - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                // close all JDBC elements
                statement.close();
                //resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
