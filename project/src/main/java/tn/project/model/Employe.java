package tn.project.model;

import java.util.Date;

public class Employe {
  
	private int id;
	private String nomEmpl;
	private String prenomEmpl;
	private String emailEmpl;
	private  String dateNaissanceEmpl;
	private Equipe Equipe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomEmpl() {
		return nomEmpl;
	}
	public void setNomEmpl(String nomEmpl) {
		this.nomEmpl = nomEmpl;
	}
	public String getPrenomEmpl() {
		return prenomEmpl;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nomEmpl=" + nomEmpl + ", prenomEmpl=" + prenomEmpl + ", emailEmpl=" + emailEmpl
				+ ", dateNaissanceEmpl=" + dateNaissanceEmpl + ", Equipe=" + Equipe + "]";
	}
	public void setPrenomEmpl(String prenomEmpl) {
		this.prenomEmpl = prenomEmpl;
	}
	public String getEmailEmpl() {
		return emailEmpl;
	}
	public void setEmailEmpl(String emailEmpl) {
		this.emailEmpl = emailEmpl;
	}
	public String getDateNaissanceEmpl() {
		return dateNaissanceEmpl;
	}
	public void setDateNaissanceEmpl(String dateNaissanceEmpl) {
		this.dateNaissanceEmpl = dateNaissanceEmpl;
	}
	public Equipe getEquipe() {
		return Equipe;
	}
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
	public Employe(int id, String nomEmpl, String prenomEmpl, String emailEmpl, String dateNaissanceEmpl,
			tn.project.model.Equipe equipe) {
		super();
		this.id = id;
		this.nomEmpl = nomEmpl;
		this.prenomEmpl = prenomEmpl;
		this.emailEmpl = emailEmpl;
		this.dateNaissanceEmpl = dateNaissanceEmpl;
		Equipe = equipe;
	}
	public Employe() {
		super();
	}
	
	
	
}
