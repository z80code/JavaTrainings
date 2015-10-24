package com.itclass.jdbc.statements;

import java.sql.*;
import java.util.ResourceBundle;

public class Insert {


    /*

    CREATE TABLE TEST(
     ID INT PRIMARY KEY auto_increment,
     NAME VARCHAR(255),
     NUMBER DOUBLE

    );
    INSERT INTO TEST(name, number) VALUES( 'Hello', 432);
    INSERT INTO TEST(name, number) VALUES( 'World', 566);
     */
    public static void main(String[] args) {

        ResourceBundle resourceBundle =
                ResourceBundle.getBundle("database");

        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        try(Connection conn = DriverManager.getConnection(url,
                user,password)) {

            String insertSql
                    = "insert into test(name, number) values(?,?)";

            try(PreparedStatement statement
                        = conn.prepareStatement(insertSql)) {

                statement.setString(1, "MY TEXT");
                statement.setDouble(2, 123.1234);

                statement.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }

            try(PreparedStatement statement
                        = conn.prepareStatement("select * from test")) {
                ResultSet dataSet = statement.executeQuery();

                while (dataSet.next()) {
                    int id = dataSet.getInt("id");
                    String text = dataSet.getString("name");
                    double number = dataSet.getDouble("number");
                    System.out.println(String.format("|%d|%s|%f|", id, text, number));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
