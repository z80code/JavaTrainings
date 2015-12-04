package com.itclass.services;

import java.util.List;

import com.itclass.model.Post;

public interface BlogService {
	List<Post> getAll();
}