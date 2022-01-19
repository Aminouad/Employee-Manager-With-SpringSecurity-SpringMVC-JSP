package tn.project.model;

public class Equipe {
	private int idEquipe;
	private String nomEquipe;
	private String descriptionEquipe;
	public int getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}
	public Equipe() {
		super();
	}
	public Equipe(int idEquipe, String nomEquipe, String descriptionEquipe) {
		super();
		this.idEquipe = idEquipe;
		this.nomEquipe = nomEquipe;
		this.descriptionEquipe = descriptionEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	@Override
	public String toString() {
		return "Equipe [nomEquipe=" + nomEquipe + "]";
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public String getDescriptionEquipe() {
		return descriptionEquipe;
	}
	public void setDescriptionEquipe(String descriptionEquipe) {
		this.descriptionEquipe = descriptionEquipe;
	}
}
