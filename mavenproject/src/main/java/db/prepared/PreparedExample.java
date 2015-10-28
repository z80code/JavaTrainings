package db.prepared;

import java.sql.*;
import java.util.ResourceBundle;

public class PreparedExample {

    public static void main(String[] args) {

        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");


        try ( Connection conn = DriverManager
                .getConnection(url,
                        user, password)) {


            int id = 12;
            String text = "some text";
            double number = 34.23;

            String insertQuery = "INSERT INTO TEST(ID, NAME, NUMBER) VALUES(?, ?, ? )";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,text);
            preparedStatement.setDouble(3,number);

            preparedStatement.executeUpdate();

            print(conn);

            // add application code here
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void print(Connection conn) throws SQLException {
        try (Statement statement = conn.createStatement()) {

            ResultSet dataSet =
                    statement.executeQuery("select * from test");

            while (dataSet.next()) {
                int id = dataSet.getInt("Id");
                String name = dataSet.getString("Name");
                double number = dataSet.getDouble("number");

                System.out.format("%d %s %f \n", id, name, number);
            }


        }
    }
}
