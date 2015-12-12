package com.nesterione;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.StringCharacterIterator;

public class ResultLoader {

    private static int getIdWithInsertion(String name, PreparedStatement psSelect, PreparedStatement psInsert) throws SQLException {
        psSelect.setString(1,name);
        ResultSet resultSet = psSelect.executeQuery();

        int id;
        if(resultSet.first()) {
            id = resultSet.getInt(1);
        } else {
            id = insert(name, psInsert);
        }

        return id;
    }

    /**
     *
     * @param name
     * @param spInsert
     * @return generated Id
     * @throws SQLException
     */
    private static int insert(String name, PreparedStatement spInsert) throws SQLException {

        spInsert.setString(1, name);

        int affectedRows = spInsert.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        int generatedId;
        try (ResultSet generatedKeys = spInsert.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        return generatedId;
    }

    public static void loadResults(ResultDAO reader) throws LoaderException, SQLException, ClassNotFoundException {

        Connection connection = ConnectionManager.getConnection();

        try {
            PreparedStatement psGetIdByLogin = connection.prepareStatement("SELECT idLogin FROM logins WHERE name = ?");
            PreparedStatement psGetIdByTest = connection.prepareStatement("SELECT idTest FROM tests WHERE name = ?");
            PreparedStatement psInsertLogin = connection.prepareStatement("INSERT INTO logins(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement psInsertTest = connection.prepareStatement("INSERT INTO tests(name) values(?)", Statement.RETURN_GENERATED_KEYS);

            PreparedStatement psInsertResult = connection.prepareStatement("INSERT INTO results(loginId,testId,dat,mark) values(?,?,?,?)");

            while (reader.hasResult()) {

                Result result = reader.nextResult();
                System.out.println(result);


                String login = result.getLogin();
                String test = result.getTest();

                int idLogin = getIdWithInsertion(login, psGetIdByLogin, psInsertLogin );
                int idTest = getIdWithInsertion(test, psGetIdByTest, psInsertTest );

                // Insertion in op table
                psInsertResult.setInt(1, idLogin);
                psInsertResult.setInt(2, idTest);
                psInsertResult.setDate(3, result.getDate());
                psInsertResult.setInt(4, result.getMark());

                int affectedRows = psInsertResult.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }
            }

        } finally {
            reader.close();
        }

    }
}
