package com.itclass;

import org.h2.Driver;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/*
 CREATE TABLE TEST(
 ID INT PRIMARY KEY auto_increment,
 NAME VARCHAR(255),
 NUM INT
 );

 INSERT INTO TEST VALUES(1, 'Hello',2342);
 INSERT INTO TEST VALUES(2, 'World',675);
 */
public class App 
{

    public static void main( String[] args ) throws ClassNotFoundException {
        String driver = "org.h2.Driver";
        String url = "jdbc:h2:~/jdbcLearn";
        String user = "igor";
        String password = "123";

        Class.forName(driver);

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = null;

            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                        try {
                            resultSet = statement.executeQuery("SELECT * FROM TEST");

                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String name = resultSet.getString("name");
                                int num = resultSet.getInt("num");

                                System.out.format("%d %s %d \n", id, name, num);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            if(resultSet!=null) {
                                resultSet.close();
                            }
                        }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(statement!=null) {
                    statement.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Apache
        // Google Guava
    }
}
