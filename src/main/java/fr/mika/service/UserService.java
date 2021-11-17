package fr.mika.service;

import java.util.ArrayList;
import java.util.List;

import fr.mika.model.User;

public class UserService {
	private static UserService instance;
	private List<User> users;
	
	
	private UserService () {
		users = new ArrayList<User>();
		User user;
		user = new User("toto", "famille", "toto", "tata", 21);
		users.add(user);
		user = new User("titi", "grosminet", "titi", "alpha", 35);
		users.add(user);
		user = new User("bruce", "lee", "hokuto", "beta", 31);
		users.add(user);
		user = new User("eliott", "reese", "blonde", "gamma", 2);
		users.add(user);
		
	}
	
	
	public static UserService getInstance() {
		if (instance==null)
			instance = new UserService();
		return instance;
	}
	
	
	public List<User> getUsers() {
		return users;
	}
}
