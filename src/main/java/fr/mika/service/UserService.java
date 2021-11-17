package fr.mika.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.mika.model.Formation;
import fr.mika.model.User;

public class UserService {
	private static UserService instance;
	private List<User> users;
	
	
	private UserService () {
		users = new ArrayList<User>();
		Random rand = new Random();
		User user;
		user = new User("toto", "famille", "toto", "tata", 21);
		users.add(user);
		user.setNote(rand.nextInt(21));
		user = new User("titi", "grosminet", "titi", "alpha", 35);
		users.add(user);
		user.setNote(rand.nextInt(21));
		user = new User("bruce", "lee", "hokuto", "beta", 31);
		users.add(user);
		user.setNote(rand.nextInt(21));
		user = new User("eliott", "reese", "blonde", "gamma", 2);
		user.setNote(rand.nextInt(21));
		users.add(user);
		
		List<Formation> formations = FormationService.getInstance().getFormations();
		for (User u : users) {
			Formation f = formations.get(rand.nextInt(formations.size()));
			u.setFormation(f);
		}
		
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
