package fr.mika.service;

import java.util.ArrayList;
import java.util.List;

import fr.mika.model.Formation;
import fr.mika.model.User;

public class FormationService {
	private static FormationService instance;
	private List<Formation> formations;
	
	
	private FormationService () {
		formations = new ArrayList<Formation>();
		
		Formation f;
		f = new Formation("Dev web", "Html, CSS, Servlet, ...", 20);
		formations.add(f);
		f = new Formation("Dev ops", "Git, Cloud, Docker, ...", 11);
		formations.add(f);
		f = new Formation("Charcuterie", "Pâté, Saucisson, Rillette, Jambon, ...", 42);
		formations.add(f);
		
	}
	
	
	public static FormationService getInstance() {
		if (instance==null)
			instance = new FormationService();
		return instance;
	}
	
	
	public List<Formation> getFormations() {
		return formations;
	}
}
