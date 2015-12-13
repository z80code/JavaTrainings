package com.nesterione;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class RunnerInt {

    public static void main(String[] args) throws LoaderException, SQLException, ClassNotFoundException {

        ResultDAO resultDAO = new CsvResult("e:/students.csv");
        ResultLoader.loadResults(resultDAO);

        //3
        String aggregationQuery = "select name, avg(  cast( mark as double) )  as mean\n" +
                                 "from logins\n" +
                                 "inner join results on logins.idLogin = results.loginId\n" +
                                 "group by name\n" +
                                 "order by mean desc;";

        PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(aggregationQuery);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("name, mean");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double mean = resultSet.getDouble("mean");

            System.out.format("%s, %.2f\n",name, mean);
        }

    }
}
