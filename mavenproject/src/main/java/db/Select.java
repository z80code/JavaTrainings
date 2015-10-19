package db;

import java.sql.*;

public class Select {


    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        //Class.forName("org.h2.Driver");

        Connection conn = DriverManager
                .getConnection("jdbc:h2:~/testdb",
                        "dbuser", "123");

        Statement statement = conn.createStatement();


       //
       statement.executeUpdate("insert into test(Name, Number)values('sdf', 234.23)");

        ResultSet dataSet =
                statement.executeQuery("select * from test");

        while (dataSet.next()) {
            int id = dataSet.getInt("Id");
            String name = dataSet.getString("Name");
            double number = dataSet.getDouble("number");

            System.out.format("%d %s %f \n", id,name,number);
        }

        conn.close();
    }

}
