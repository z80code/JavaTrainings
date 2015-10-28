package db.useproperties;

import java.sql.*;
import java.util.ResourceBundle;

public class MetaInfo {

    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("database");

        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");

        try (Connection conn = DriverManager
                .getConnection(url, user, password)) {

            DatabaseMetaData databaseMetaData = conn.getMetaData();
            System.out.println(databaseMetaData.getDatabaseProductName());

            try(Statement statement = conn.createStatement()) {
                ResultSet dataSet =
                        statement.executeQuery("select * from test");


                ResultSetMetaData metaData =  dataSet.getMetaData();
                System.out.println(metaData.getColumnCount());
                System.out.println(metaData.getColumnType(1));
                System.out.println(metaData.getColumnTypeName(1));
                System.out.println(metaData.getTableName(1));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
