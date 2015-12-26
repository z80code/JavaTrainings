package com.itclass.controller;

public class Post {
	
	private Integer id;
	private String title;
	
	public Post() {	}

	public Post(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + "]";
	}
	
}
