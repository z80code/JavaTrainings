package db.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestTable {

    public List<User> getAll() throws SQLException {

        List<User> users = new ArrayList<>();

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
            users.add(new User(id,name,number));
        }

        conn.close();

        return users;
    }

    public void add(User user) {
        //
    }
}
