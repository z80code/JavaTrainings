package com.itclass.model;

import java.util.Date;
/*
 * CREATE TABLE Articles (
              ID INT PRIMARY KEY auto_increment, 
              title VARCHAR(100),
              author VARCHAR(100),
              text VARCHAR(500),
              date TIMESTAMP,
	);
	
insert into articles(title, author, text, date) values( 'a1', 'author1', 'text 1', '2015-11-16 18:49:10');
insert into articles(title, author, text, date) values( 'a2', 'author2', 'text 2', '2015-11-16 18:49:10');

 */


public class Article {
	
	private int id;
	private String title;
	private String author;
	private String text;
	private Date date;
	
	public Article() { }

	public Article(int id, String title, String author, String text, Date date) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.text = text;
		this.date = date;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", text=" + text + ", date=" + date
				+ "]";
	}
	
	
}