package db.useproperties;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by igor on 22.10.2015.
 */
public class Select {
	
	

    public static void main(String[] args) {

        ResourceBundle resource = ResourceBundle.getBundle("database");
        
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");
        
        
        try ( Connection conn = DriverManager
                .getConnection(url, user, password)) {

            try(Statement statement = conn.createStatement()) {

                statement.executeUpdate("insert into test(Name, Number)" +
                        "values('sdf', 234.23)");

                ResultSet dataSet =
                        statement.executeQuery("select * from test");

                while (dataSet.next()) {
                    int id = dataSet.getInt("Id");
                    String name = dataSet.getString("Name");
                    double number = dataSet.getDouble("number");

                    System.out.format("%d %s %f \n", id, name, number);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
