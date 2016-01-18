package com.itclass.singletone;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by igor on 17.01.2016.
 */
public class AppJ7 {

    //resources
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = DataSource.getInstance().getConnection();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST")) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int num = resultSet.getInt("num");

                    System.out.format("%d %s %d \n", id, name, num);
                }
            }
        }

    }
}
