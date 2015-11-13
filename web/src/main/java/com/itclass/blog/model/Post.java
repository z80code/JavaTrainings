package com.itclass.blog.model;

import java.util.Date;
import java.util.List;

public class Post {
	
	// id : Integer
	// title : String
	// created : Date
	// lastChange : Date
	// tags : List<String>
	
	// getters/setters
	// constructor with parameters
	// default constructor
	
	private int id;
	private String title;
	private Date created;
	private Date lastChange;
	private String content;
	private List<String> tags;
	
	public Post() { }
	
	public Post(int id, String title, Date created, Date lastChange, String content, List<String> tags) {
		this.id = id;
		this.title = title;
		this.created = created;
		this.lastChange = lastChange;
		this.content = content;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
