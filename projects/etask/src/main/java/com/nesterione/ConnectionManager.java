package com.nesterione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {


    private static final String URI = "jdbc:h2:~/jsedb";
    private static final String USER = "jse";
    private static final String PASSWORD = "jse";

    // This is static class
    private ConnectionManager() {}

    private static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        if(connection==null||connection.isClosed()) {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URI,USER,PASSWORD);
        }

        return connection;
    }

}
