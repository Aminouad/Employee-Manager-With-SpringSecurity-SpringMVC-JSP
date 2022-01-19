package tn.project.model;

import java.util.Date;

public class Tache {

	
	
	private int idTache;
	private String descriptionTache;
	private int chargeHoraireTache;
	private int prioriteTache;
	private String statusTache;
	private String dateDebutTache;
	private String dateFinTache;
	private Employe employe;
	private Projet projet;
	public int getIdTache() {
		return idTache;
	}
	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	public String getDescriptionTache() {
		return descriptionTache;
	}
	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}
	public int getChargeHoraireTache() {
		return chargeHoraireTache;
	}
	public void setChargeHoraireTache(int chargeHoraireTache) {
		this.chargeHoraireTache = chargeHoraireTache;
	}
	public int getPrioriteTache() {
		return prioriteTache;
	}
	public void setPrioriteTache(int prioriteTache) {
		this.prioriteTache = prioriteTache;
	}
	public String getStatusTache() {
		return statusTache;
	}
	public void setStatusTache(String statusTache) {
		this.statusTache = statusTache;
	}
	public String getDateDebutTache() {
		return dateDebutTache;
	}
	public void setDateDebutTache(String dateDebutTache) {
		this.dateDebutTache = dateDebutTache;
	}
	public String getDateFinTache() {
		return dateFinTache;
	}
	public void setDateFinTache(String dateFinTache) {
		this.dateFinTache = dateFinTache;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Tache(int idTache, String descriptionTache, int chargeHoraireTache, int prioriteTache, String statusTache,
			String dateDebutTache, String dateFinTache, Employe employe, Projet projet) {
		super();
		this.idTache = idTache;
		this.descriptionTache = descriptionTache;
		this.chargeHoraireTache = chargeHoraireTache;
		this.prioriteTache = prioriteTache;
		this.statusTache = statusTache;
		this.dateDebutTache = dateDebutTache;
		this.dateFinTache = dateFinTache;
		this.employe = employe;
		this.projet = projet;
	}
	public Tache() {
		super();
	}
	
	
}
