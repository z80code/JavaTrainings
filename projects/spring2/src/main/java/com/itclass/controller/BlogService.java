package com.itclass.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
	
	private static Map<Integer, Post> dao = new HashMap<>();
	
	private static int currentId = 1;
	private static int nextId() {
		return currentId++;
	}
	
	public List<Post> getAll() {
		return new ArrayList<> (dao.values());
	}
	
	public void save(Post post) {
		System.out.println(" service: save ");
		post.setId( BlogService.nextId() );
		dao.put(post.getId(), post);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void createPost(Post post) {
		System.out.println("create");
		dao.put(post.getId(), post);
	}
	
	public Post getById(int id) {
		return dao.get(id);
	}
}
