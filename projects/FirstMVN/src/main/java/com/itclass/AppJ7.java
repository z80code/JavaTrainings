package com.itclass;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by igor on 17.01.2016.
 */
public class AppJ7 {

    //resources

    public static void main(String[] args) throws ClassNotFoundException {

        ResourceBundle resourceBundle
                = ResourceBundle.getBundle("config");

        String driver = resourceBundle.getString("db.driver");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        Class.forName(driver);


        try(Connection connection
                    = DriverManager.getConnection(url, user, password)) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST")) {

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int num = resultSet.getInt("num");

                        System.out.format("%d %s %d \n", id, name, num);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
