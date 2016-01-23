package com.itclass.services;

import java.util.HashMap;
import java.util.Map;

import com.itclass.model.*;

public class UserService {

	private static Map<String, User> users = new HashMap<>();
	
	static {
		User user1 = new User("nesterione@gmail.com", "123", Role.USER);
		users.put(user1.getEmail(), user1);
		
		User user2 = new User("admin@gmail.com", "123", Role.ADMIN);
		users.put(user2.getEmail(), user2);
	}
	
	public User getUserByEmail(String email) {
		return UserService.users.get(email);
	}
	
	public boolean checkUserPassword(String email, String password) {
		
		User user = UserService.users.get(email);
		if(user!=null) {
			return user.getPassword().equals(password);
		}
		
		return false;
	}
	
	public synchronized  boolean addUser(User user) {
	
		return false;
	}
}