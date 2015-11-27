package com.itclass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public abstract class AbstractDAO<K,T> implements AutoCloseable {
	
	final protected Connection connection;
	
	public AbstractDAO() throws SQLException {
		
		ResourceBundle resources = ResourceBundle.getBundle("connection");
		
		String url = resources.getString("db.url");
		String user = resources.getString("db.user");
		String password = resources.getString("db.password");
		
		connection = DriverManager.getConnection(url, user, password);
	}
	
	// CRUD
	public abstract List<T> getAll() throws SQLException;
	public abstract T get(K key);
	public abstract void delete(K key);
	public abstract void update(T entity);
	public abstract void add(T entity);
	
	@Override
	public void close() throws Exception {
		connection.close();
	}
	
}
