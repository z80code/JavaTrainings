package com.itclass.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itclass.dao.AbstractDAO;
import com.itclass.dao.PostDAO;
import com.itclass.model.Post;

public class BlogService {
	
	/**
	 *  
	 * @return return posts or empty list (if error)
	 * @throws Exception 
	 */
	public List<Post> getAllPosts() throws Exception {
		
		List<Post> posts = new ArrayList<>();
		
		try(AbstractDAO<Integer, Post> dao = new PostDAO()) {
			posts = dao.getAll();
		}
		
		return posts;
	}

	public void savePost(Post post) throws ClassNotFoundException, SQLException, Exception {
		
		try(AbstractDAO<Integer, Post> dao = new PostDAO()) {
			dao.add(post);
		}
		
	}
	
	public Post getPostById(int id) throws ClassNotFoundException, SQLException, Exception {
		
		Post post;
		
		try(AbstractDAO<Integer, Post> dao = new PostDAO()) {
			post = dao.get(id);
		}
		
		return post;
	}
}