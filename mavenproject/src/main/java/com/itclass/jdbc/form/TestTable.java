package com.itclass.jdbc.form;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestTable {

    public List<RecordEntity> getAll() throws SQLException {

        List<RecordEntity> entities = new ArrayList<>();
        try (Connection conn = DriverManager
                .getConnection("jdbc:h2:~/newtestdb", "yourname", "123qwe")) {
            Statement statement = conn.createStatement();
            ResultSet dataSet = statement.executeQuery("select * from test");

            while (dataSet.next()) {
                int id = dataSet.getInt("id");
                String text = dataSet.getString("text");
                double number = dataSet.getDouble("number");
                entities.add(new RecordEntity(id,text,number));
            }
        }

        return entities;
    }
}