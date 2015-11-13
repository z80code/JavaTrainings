package com.itclass.blog.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.itclass.blog.model.Post;

public class PostDAO {

	private static List<Post> posts;
	
	static {
		String text = "text text text text text text text text text text text text text text text text text text ";
		Post post1 = new Post(1, "Пост1", new Date(), new Date(), text, Arrays.asList("tag1", "tag2"));
		Post post2 = new Post(2, "Пост2", new Date(), new Date(), text, Arrays.asList("tag2"));
		Post post3 = new Post(3, "Пост3", new Date(), new Date(), text, Arrays.asList("tag2"));
		Post post4 = new Post(4, "Пост4", new Date(), new Date(), text, Arrays.asList("tag1", "tag2", "tag3"));
		Post post5 = new Post(5, "Пост5", new Date(), new Date(), text, Arrays.asList("tag2"));
		
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
	
}