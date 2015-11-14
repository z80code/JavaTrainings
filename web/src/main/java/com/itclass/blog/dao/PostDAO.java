package com.itclass.blog.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.itclass.blog.model.Post;

public class PostDAO {

	private static List<Post> posts;
	
	private static int currentId = 0;
	public static int nextId() {
		return currentId++;
	}
	
	static {
		String text = "text text text text text text text text text text text text text text text text text text ";
		Post post1 = new Post(nextId(), "Пост1", new Date(), new Date(), text, Arrays.asList("tag1", "tag2"));
		Post post2 = new Post(nextId(), "Пост2", new Date(), new Date(), text, Arrays.asList("tag2"));
		Post post3 = new Post(nextId(), "Пост3", new Date(), new Date(), text, Arrays.asList("tag2"));
		Post post4 = new Post(nextId(), "Пост4", new Date(), new Date(), text, Arrays.asList("tag1", "tag2", "tag3"));
		Post post5 = new Post(nextId(), "Пост5", new Date(), new Date(), text, Arrays.asList("tag2"));
		
		posts = new ArrayList<Post>();
		posts.add(post1);
		posts.add(post2);
		posts.add(post3);
		posts.add(post4);
		posts.add(post5);
	}
	
	public List<Post> getAll() {
		return PostDAO.posts;
	}
	
	public Post get(int id) {
		
		for(Post post : PostDAO.posts) {
			if(post.getId() == id) {
				return post;
			}
		}
		
		return null;
	}
	
	public void add(Post post) {
		posts.add(post);
	}
	
}