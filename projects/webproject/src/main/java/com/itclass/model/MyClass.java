package com.itclass.model;

public class MyClass {
	
	private int id;
	private String name;
	private double justNumber;
	
	public MyClass() {
	}

	public MyClass(int id, String name, double justNumber) {
		this.id = id;
		this.name = name;
		this.justNumber = justNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getJustNumber() {
		return justNumber;
	}

	public void setJustNumber(double justNumber) {
		this.justNumber = justNumber;
	}

	@Override
	public String toString() {
		return "MyClass [id=" + id + ", name=" + name + ", justNumber=" + justNumber + "]";
	}
	
}
