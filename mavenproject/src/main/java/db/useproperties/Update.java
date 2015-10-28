package db.useproperties;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by igor on 22.10.2015.
 */
public class Update {

    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("database");

        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");

        try (Connection conn = DriverManager
                .getConnection(url, user, password)) {

            String sql = "insert into test(id, Name, Number) values(?, ?, ?)";

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, 45);
                statement.setString(2, "Some text");
                statement.setDouble(3, 111.222);

                statement.executeUpdate();
            }


            try(Statement statement = conn.createStatement()) {
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
