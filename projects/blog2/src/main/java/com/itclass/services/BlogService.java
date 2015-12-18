package com.itclass.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.itclass.model.Post;

public class BlogService {

	private static final List<Post> posts;
	
	static {
		posts = new ArrayList<>();
		posts.add(new Post(1, "post 1", new Date(), new Date(), "Русский текст ", "tag1 tag2"));
		posts.add(new Post(2, "post 2", new Date(), new Date(), "text ", "tag2"));
		posts.add(new Post(3, "post 3", new Date(), new Date(), "text ", "tag1"));
	}
	
	public List<Post> getAll() {
		return posts;
	}
	
	public Post get(int id) {
		
		for(Post post: posts) {
			if(post.getId()==id){
				return post;
			}
		}
		
		return null;
	}

	public void save(Post post) {
		
		// TODO For test only!!
		Random r = new Random();
		post.setId( r.nextInt());
		
		
		posts.add(post);
	}
	
}