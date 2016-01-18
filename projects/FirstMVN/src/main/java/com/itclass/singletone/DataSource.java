package com.itclass.singletone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSource {

    private DataSource() { }

    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        if(connection==null || connection.isClosed()) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
            String driver = resourceBundle.getString("db.driver");
            String url = resourceBundle.getString("db.url");
            String user = resourceBundle.getString("db.user");
            String password = resourceBundle.getString("db.password");
            Class.forName(driver);

            connection = DriverManager.getConnection(url, user, password);
        }

        return connection;
    }



    private static DataSource dataSource;
    public static DataSource getInstance() {
        if(dataSource==null) {
            dataSource = new DataSource();
        }

        return dataSource;
    }


}
