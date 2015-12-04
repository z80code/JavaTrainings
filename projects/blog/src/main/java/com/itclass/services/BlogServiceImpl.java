package com.itclass.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itclass.model.Post;

public class BlogServiceImpl implements BlogService{

	private final List<Post> posts;
	
	public BlogServiceImpl() {
		posts = new ArrayList<>();
		posts.add(new Post(1, "post 2", new Date(), new Date(), "text ", "tag1 tag2"));
		posts.add(new Post(1, "post 2", new Date(), new Date(), "text ", "tag2"));
		posts.add(new Post(1, "post 2", new Date(), new Date(), "text ", "tag1"));
	}
	
	public List<Post> getAll() {
		return posts;
	}
	
}