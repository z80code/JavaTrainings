package com.itclass.dao;

import java.io.Reader;
import java.io.StringReader;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itclass.model.Post;

public class PostDAO extends AbstractDAO<Integer, Post> {

	private final String GET_ALL_QUERY = "select * from posts";

	public PostDAO() throws SQLException, ClassNotFoundException {
		super();
	}

	@Override
	public List<Post> getAll() throws SQLException {

		List<Post> posts = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(GET_ALL_QUERY)) {

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				Timestamp created = resultSet.getTimestamp("created");
				Timestamp lastChanged = resultSet.getTimestamp("lastChanged");
				Clob content = resultSet.getClob("content");
				String tags = resultSet.getString("tags");

				Post post = new Post(id, title, new Date(created.getTime()), new Date(lastChanged.getTime()),
						// TODO только если не предпологается, что в CLOB
						// количество символов < int
						content.getSubString(1L, (int) content.length()), tags);

				posts.add(post);
			}
		}
		return posts;
	}

	private final String GET_BY_ID_QUERY 
		= "select * from posts where id=?";
	
	@Override
	public Post get(Integer key) throws SQLException {
		
		Post post = null;
		
		try (PreparedStatement statement 
				= connection.prepareStatement(GET_BY_ID_QUERY)) {

			statement.setInt(1, key);	
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			
			Integer id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			Timestamp created = resultSet.getTimestamp("created");
			Timestamp lastChanged = resultSet.getTimestamp("lastChanged");
			Clob content = resultSet.getClob("content");
			String tags = resultSet.getString("tags");

			post = new Post(id, title, new Date(created.getTime()), new Date(lastChanged.getTime()),
			// TODO только если не предпологается, что в CLOB
			// количество символов < int
			content.getSubString(1L, (int) content.length()), tags);
		}
		
		
		return post;
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Post entity) {
		// TODO Auto-generated method stub

	}

	private final String INSERT_QUERY = "insert into posts(title, created, lastChanged, content, tags) "
			+ "values(?,?,?,?,?)";

	@Override
	public void add(Post entity) throws SQLException {
		try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
						
			statement.setString(1, entity.getTitle());
			
			Timestamp created = new Timestamp(entity.getCreated().getTime());
			statement.setTimestamp(2, created);
			
			Timestamp changed = new Timestamp(entity.getLastChanged().getTime());
			statement.setTimestamp(3, changed);
			
			Reader reader = new StringReader(entity.getContent());
			statement.setClob(4, reader);
			
			statement.setString(5, entity.getTags());
			
			
			// TODO нужны проверки, на то, были ли изменены строки
			statement.executeUpdate();
			
		}
	}

}
