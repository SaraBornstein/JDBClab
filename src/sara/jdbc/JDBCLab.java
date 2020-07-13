package sara.jdbc;

import java.sql.*;
import java.util.ArrayList;

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
 *
 *
 **/

public class JDBCLab {

    public static void main(String[] args) {
        DBCrud lab = new DBCrud(); //create new object of class DBCrud
        boolean success = lab.run(); //use the object to call the run method from the other class, use the boolean to find out if it ran or not
            if (success){
                System.out.println("Lab ran successfully!");
            } else {
                System.out.println("Lab failed.");
            }
    }
}
