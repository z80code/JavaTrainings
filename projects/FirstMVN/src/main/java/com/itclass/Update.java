package com.itclass;

import java.sql.*;

public class Update {

    public static void main(String[] args) throws ClassNotFoundException {
        String driver = "org.h2.Driver";
        String url = "jdbc:h2:~/jdbcLearn";
        String user = "igor";
        String password = "123";

        Class.forName(driver);

        try(Connection connection = DriverManager.getConnection(url, user, password)) {

            String sql = "INSERT INTO TEST(name, num) VALUES(?,?)";

            try(PreparedStatement statement
                        = connection.prepareStatement(sql)) {

                // CallableStatement

                String name = "; DELETE * FROM TEST; --";
                int num = 777;

                statement.setString(1,name);
                statement.setInt(2, num);

                //String query = "INSERT INTO TEST(name, num) VALUES("+name+","+num+")";
                //String query = String.format("INSERT INTO TEST(name, num) VALUES(%s,%d)",name,num);

                // SQL Injection
                //System.out.println(query);


                statement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
