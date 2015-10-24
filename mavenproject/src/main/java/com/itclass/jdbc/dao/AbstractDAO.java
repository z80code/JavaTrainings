package com.itclass.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public abstract class AbstractDAO<E> implements AutoCloseable {

    final protected Connection connection;

    public AbstractDAO() throws SQLException {

        ResourceBundle resourceBundle =
                ResourceBundle.getBundle("database");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        connection = DriverManager.getConnection(url, user, password);
    }

    public abstract List<E> getAll();
    public abstract E get(int id);
    public abstract boolean delete(int id);
    public abstract boolean update(E entity);
    public abstract boolean insert(E entity);

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
