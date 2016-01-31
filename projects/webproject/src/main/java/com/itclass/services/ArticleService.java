package com.itclass.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.itclass.model.Article;

public class ArticleService implements AutoCloseable {
	
	final private String SELECT_QUERY = "SELECT * FROM ARTICLES ";
	final private String 
		GET_BY_ID_QUERY = "SELECT * FROM ARTICLES WHERE id=?";
	
	final private Connection connection;
	
	public ArticleService() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:h2:~/newsdb";
		String user = "igor";
		String password = "123";
		String driver = "org.h2.Driver";
		
		Class.forName(driver);
		
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		
		try(ArticleService s = new ArticleService()) {
			List<Article> articles = s.getAll();
			System.out.println(articles);
		}	
	}
	
	public void save(Article article) {
		
	}
	
	public List<Article> getAll() throws SQLException {
		
		List<Article> articles = new ArrayList<>();
		
		try (PreparedStatement statement 
				= connection.prepareStatement(SELECT_QUERY) ) {
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				int id = result.getInt("id");
				String title = result.getString("title");
				String author = result.getString("author");
				String text = result.getString("text");
				Timestamp date = result.getTimestamp("date");
				
				Article article = new Article(id, title, author, text, date);
				 
				articles.add(article);
			}
			
			
		}
		
		return articles;
	}

	@Override
	public void close() throws Exception {
		if(connection!=null) {
			connection.close();
		}
	}

 
		
}
