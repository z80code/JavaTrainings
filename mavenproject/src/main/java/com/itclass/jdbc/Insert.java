package com.itclass.jdbc;

import java.sql.*;

public class Insert {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:~/newtestdb", "yourname", "123qwe");

        Statement statement = conn.createStatement();

        String insertQuery =
                "INSERT INTO TEST VALUES(5, 'my text', 234.3 )";
        statement.executeUpdate(insertQuery);


        // add application code here

        conn.close();
    }

}
