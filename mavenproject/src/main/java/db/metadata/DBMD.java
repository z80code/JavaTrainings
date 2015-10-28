package db.metadata;

import java.sql.*;
import java.util.ResourceBundle;

public class DBMD {

    public static void main(String[] args) {

        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");


        try (Connection conn = DriverManager
                .getConnection(url,
                        user, password)) {

            DatabaseMetaData databaseMetaData = conn.getMetaData();
            System.out.println(databaseMetaData.getURL());
            System.out.println(databaseMetaData.getDatabaseProductName());
            System.out.println(databaseMetaData.getUserName());
            System.out.println(databaseMetaData.getCatalogs());

            try (Statement statement = conn.createStatement()) {

                ResultSet dataSet =
                        statement.executeQuery("select * from test");

                ResultSetMetaData resultSetMetaData =  dataSet.getMetaData();
                System.out.println(resultSetMetaData.getColumnCount());
                System.out.println(resultSetMetaData.getColumnType(1));
                System.out.println(resultSetMetaData.getColumnTypeName(1));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
