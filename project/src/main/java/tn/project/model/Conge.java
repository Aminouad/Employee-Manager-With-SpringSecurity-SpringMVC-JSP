package tn.project.model;


public class Conge {

	
	private int idConge;
	private String dateD;
	private String dateF;
	private Employe empl;
	public Conge() {
		super();
	}
	public Conge(int idConge, String dateD, String dateF, Employe empl) {
		super();
		this.idConge = idConge;
		this.dateD = dateD;
		this.dateF = dateF;
		this.empl = empl;
	}
	public int getIdConge() {
		return idConge;
	}
	public void setIdConge(int idConge) {
		this.idConge = idConge;
	}
	public String getDateD() {
		return dateD;
	}
	public void setDateD(String dateD) {
		this.dateD = dateD;
	}
	public String getDateF() {
		return dateF;
	}
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}
	public Employe getEmpl() {
		return empl;
	}
	public void setEmpl(Employe empl) {
		this.empl = empl;
	}
	
	
}
