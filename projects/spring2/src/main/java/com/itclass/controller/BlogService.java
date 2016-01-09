package com.itclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
	
	private Map<Integer, Post> posts = new HashMap<Integer, Post>();
	
	public void createPost(Post post) {
		System.out.println("create");
		posts.put(post.getId(), post);
	}
	
	public Post getById(int id) {
		return posts.get(id);
	}
}
