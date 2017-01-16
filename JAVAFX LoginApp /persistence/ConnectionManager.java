package org.academiadecodigo.myApp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by codecadet on 28/11/16.
 */
public class ConnectionManager {

    Connection connection = null;
    private String dbName = "myApp_db";
    private String urlDB = "jdbc:mysql://test.us-east-1.rds.amazonaws.com:3306/";
    private String user = "tomasamaro";
    private String password = "";


    public ConnectionManager() {
    }

    public ConnectionManager(String urlDB, String user,String password,String dbName) {
        this.urlDB = urlDB;
        this.user = user;
        this.password = password;
        this.dbName = dbName;
    }

    public Connection getConnection() {

        try {
            if (connection == null) {
                connection = DriverManager.getConnection(urlDB + dbName, user, password);
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
        return connection;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }
}
