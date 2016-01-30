package com.itclass.services;

import com.itclass.model.Role;
import com.itclass.model.User;

public class Run {
	
	public static void main(String[] args) {
		
		DbService db = new DbService();
		System.out.println(db.getAll());
		
		db.insertUser(new User("admin", "123", Role.USER));
		System.out.println(db.getAll());
		
	}
	
}
