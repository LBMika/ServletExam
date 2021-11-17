package fr.mika.model;

public class User {
	private String nom;
	private String prenom;
	private String pwd;
	private String username;
	private int age;
	
	
	public User(String nom, String prenom, String username, String pwd, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.pwd = pwd;
		this.age = age;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
}
