package com.itclass.jdbc;

import java.sql.*;

/**
 * Created by igor on 15.10.2015.
 */
public class SelectTryCatch {
    public static void main(String[] args) {


        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/newtestdb", "yourname", "123qwe");

            try {
                Statement statement = conn.createStatement();

                ResultSet dataSet = statement.executeQuery("select * from test");

                while (dataSet.next()) {
                    int id = dataSet.getInt("id");
                    String text = dataSet.getString("text");
                    double number = dataSet.getDouble("number");

                    System.out.println(String.format("|%d|%s|%f|", id, text, number));
                }

            } catch (SQLException se) {
                System.out.println(se.getMessage());
            } finally {
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Соединение не установлено: " + e.getMessage());
        }
    }
}
