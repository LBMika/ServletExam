package fr.mika.model;

public class Formation {
	private String sujet;
	private int inscrit;
	private String programme;
	
	
	public Formation(String sujet, String programme, int inscrit) {
		super();
		this.sujet = sujet;
		this.inscrit = inscrit;
		this.programme = programme;
	}


	public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	public int getInscrit() {
		return inscrit;
	}


	public void setInscrit(int inscrit) {
		this.inscrit = inscrit;
	}


	public String getProgramme() {
		return programme;
	}


	public void setProgramme(String programme) {
		this.programme = programme;
	}
}
