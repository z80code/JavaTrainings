package com.itclass;

import java.util.HashMap;
import java.util.Map;

public class UserService {
	
	// TODO нужно использовать БД и промежуточный DAO класс
	final static private Map<String, User> dao = new HashMap<>();
	
	static {
		User u1 = new User("user","123", Role.USER);
		dao.put(u1.getUserName(), u1);
		
		User u2 = new User("admin","123", Role.ADMIN);
		dao.put(u2.getUserName(), u2);
	}
	
	
	
	public boolean checkUser(String name, String pass) {
		
		User user = dao.get(name);
		
		// TODO
		if(user !=null) {
			return user.getPassword().equals(pass);
		}
			
		return false;
	}
	
	public User getUserByName(String name) {
		return dao.get(name);
	}
	
	
	final private static Object lock = new Object();
	
	public boolean saveUser() {
		
		synchronized (lock) {
			// Проверка логина
			// сохранение
		}
		
		return false;
	}
	
}
