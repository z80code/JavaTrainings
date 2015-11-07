package com.itclass.jsp;

public class User {
	private String name;
	private String old;
	
	public User() {
		
	}
	
	public User(String name, String old) {
		this.name = name;
		this.old = old;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	
	
}
