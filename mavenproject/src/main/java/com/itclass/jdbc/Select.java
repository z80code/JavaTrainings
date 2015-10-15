package com.itclass.jdbc;

import java.sql.*;

public class Select {

    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:h2:~/newtestdb", "yourname", "123qwe");

        Statement statement = conn.createStatement();

        ResultSet dataSet = statement.executeQuery("select * from test");

        while (dataSet.next()) {
            int id = dataSet.getInt("id");
            String text = dataSet.getString("text");
            double number = dataSet.getDouble("number");

            System.out.println(String.format("|%d|%s|%f|", id, text, number));
        }

        conn.close();

    }

}
