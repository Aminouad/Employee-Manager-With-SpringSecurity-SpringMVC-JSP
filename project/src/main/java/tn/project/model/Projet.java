package tn.project.model;

public class Projet {
	
	private int idPro;
	private String nomPro;
	private String descriptionPro;	
	private int chargeHorairePro;
	private Employe employe;
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	public String getNomPro() {
		return nomPro;
	}
	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}
	public String getDescriptionPro() {
		return descriptionPro;
	}
	public void setDescriptionPro(String descriptionPro) {
		this.descriptionPro = descriptionPro;
	}
	public int getChargeHorairePro() {
		return chargeHorairePro;
	}
	public void setChargeHorairePro(int chargeHorairePro) {
		this.chargeHorairePro = chargeHorairePro;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Projet(int idPro, String nomPro, String descriptionPro, int chargeHorairePro, Employe employe) {
		super();
		this.idPro = idPro;
		this.nomPro = nomPro;
		this.descriptionPro = descriptionPro;
		this.chargeHorairePro = chargeHorairePro;
		this.employe = employe;
	}
	public Projet() {
		super();
	}

}
