package com.itclass.jdbc;


import java.sql.*;

public class Start {

    /**
     * Создать БД myh2database
     *
     * CREATE USER User PASSWORD '123qwe'
     * ALTER USER User ADMIN TRUE
     *
     * DROP TABLE IF EXISTS TEST;
     * CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));
     * INSERT INTO TEST VALUES(1, 'Hello');
     * INSERT INTO TEST VALUES(2, 'World');
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // До появления JDBC 4
        //Class.forName("org.h2.Driver");
        // или
        //DriverManager.registerDriver(new org.h2.Driver());

        //Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:8082/server~/myh2database", "User", "123qwe");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/myh2database","User","123qwe");
        // add application code here

        String selectTableSQL = "SELECT * from TEST";

        // для выполнения не подготовленных SQL запросов
        Statement statement = conn.createStatement();
        // для хранимых процедур можно использовать
        // PreparedStatement и CallableStatement

        ResultSet rs = statement.executeQuery(selectTableSQL);
        // для изменения бд statement.executeUpdate(selectTableSQL);

        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            System.out.format("%d , %s \n", id,name);
        }

        conn.close();
    }

}
