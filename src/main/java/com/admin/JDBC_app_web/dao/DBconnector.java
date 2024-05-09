package com.admin.JDBC_app_web.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/07 17:27
 */
public class DBconnector {
    /*
    Class based on singletone pattern to connect to the database.
     */

    //Variables.
    private static DBconnector instance;
    private static final Logger log = LogManager.getLogger("mainLog");
    private static final String URL = "jdbc:mysql://127.0.0.1:8889/JDBC_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    //Constructor.
    private DBconnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectToDB();
        } catch (ClassNotFoundException e) {
            log.error(new RuntimeException(e));
        }
    }

    // Methods.
    public static DBconnector getInstance() {
        if (instance == null) {
            instance = new DBconnector();
        }
        return instance;
    }

    private void connectToDB() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                log.info("Connection established.");
            }
        } catch (SQLException e) {
            log.error("Couldn't connect to the database.");
            log.error(e.getStackTrace());
        }
    }
    public void disconnectFromDB() {
        try {
            connection.close();
            if (connection.isClosed()) {
                log.info("Connection closed.");
            }
        } catch (SQLException e) {
            log.error("Couldn't close connection.");
            log.error(e.getStackTrace());
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
