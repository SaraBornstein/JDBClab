package sara.jdbc;

import java.sql.*;
import java.util.ArrayList;

public class DBCrud {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    boolean run(){
        try {
            //creating database connection
            initializeConnection();

            //inserting record
            insertRecord("someTitle", "someAuthor", 4);

            //selecting book
            Book b = findBookByTitle("someTitle");

            //Update Row
            updateBookLength(b, 300);

            //Delete book
            deleteBook(b);

            //TODO: Call method that will query all records from DB and map to array list of books and print tostring for each book
            insertRecord("Insert Book 1", "Author Num 1", 200);
            insertRecord("Insert Book 2", "Author Num 2", 400);
            mapResultSetToObjects();

            //closing connections
            closeConnections();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void initializeConnection() throws Exception {
        // This will load the MySQL driver, each DB has its own driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Could not load driver");
        }

        // Setup the connection with the DB
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/JDBClab?"
                            + "user=root&password= &useSSL=false");
        } catch (SQLException e) {
            throw new Exception("Could not create connection");
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new Exception("Could not create statement");
        }
    }

    private void insertRecord(String title, String author, int pages) throws SQLException {
        StringBuilder insert = new StringBuilder();
        insert.append("INSERT INTO JDBClab.to_be_read (title, author, pages) VALUES ('");
        insert.append(title);
        insert.append("', '");
        insert.append(author);
        insert.append("', ");
        insert.append(pages).append(")");
        statement.executeUpdate(insert.toString());
        System.out.println("Book inserted with  title: " + title);
    }

    private Book findBookByTitle(String aTitle) throws SQLException {
        resultSet = statement.executeQuery("select * from JDBClab.to_be_read WHERE title = \"" + aTitle + "\";");
        Book b = mapResultSetToBook(resultSet);
        System.out.println("Book found with Title: " + b.getTitle());
        return b;
    }

    private void updateBookLength(Book b, int length) throws SQLException {
        statement.executeUpdate("UPDATE JDBClab.to_be_read set pages = " + length + " where id = " + b.getId());
        System.out.println("Book updated to length " + length + " pages");
    }

    private void deleteBook(Book b) throws SQLException {
        statement.executeUpdate("DELETE from JDBClab.to_be_read where id = " + b.getId());
        System.out.println("Book with " + b.getId() + " deleted");
    }

    private Book mapResultSetToBook(ResultSet resultSet) throws SQLException {
        Book b = new Book();
        resultSet.next();
        b.setId(resultSet.getInt("id"));
        b.setTitle(resultSet.getString("title"));
        b.setAuthor(resultSet.getString("author"));
        b.setPages(resultSet.getInt("pages"));

        return b;
    }

    private void mapResultSetToObjects() throws SQLException {
        resultSet = statement.executeQuery("select * from JDBClab.to_be_read;");
        // call method to map ResultSet to ArrayList of objects
        ArrayList<Book> books = mapResultSetToObjects(resultSet);
        // use a for-each loop to print out each object
        for (Book b : books)
            System.out.println(b.toString());

    }

    private ArrayList<Book> mapResultSetToObjects(ResultSet resultSet) throws SQLException {
        ArrayList<Book> retList = new ArrayList();
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            Book tbr = new Book();
            tbr.setId(resultSet.getInt("id"));
            tbr.setTitle(resultSet.getString("title"));
            tbr.setAuthor(resultSet.getString("author"));
            tbr.setPages(resultSet.getInt("pages"));
            retList.add(tbr);
        }
        return retList;
    }

    private void closeConnections() throws SQLException {
        // close all JDBC elements
        statement.close();
        //resultSet.close();
        connection.close();
        System.out.println("Connections closed");
    }
}
