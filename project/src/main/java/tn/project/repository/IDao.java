package tn.project.repository;
import java.util.List;

import tn.project.model.*;
public interface IDao {

	
	public void addProjet(Projet p);
	public void addEmploye(Employe e);
	public void addEquipe(Equipe e);
	public void deleteEquipe(Equipe e);
	public void deleteEmploye(Employe emp);
	public void deleteConge(Conge c);
	public void deleteTache(Tache t);
	public void deleteProjet(Projet p);

	public void addTache(Tache t);
	public void addConge(Conge c);

	public Projet getProjetById(int idProjet);
	public Projet getProjetByEmploye(int idEmployee);
	public Equipe getEquipeById(int idEquipe);
	public Employe getEmployeById(int idEmp);
	public Conge getCongeById(int idC);
	public Tache getTacheId(int idT);

	public List<Tache> getAllTache();
	public List<Equipe> getAllEquipe();
	public List<Projet> getAllProjetByEmploye(int idEmploye);
	public List<Employe> getAllEmployeByEquipe(Equipe e);
	public List<Projet> getAllProjet();
	public List<Employe> getAllEmploye();
	public List<Conge> getAllCongeByEmploye(Employe e);
	public List<Tache> getAllTacheByEmploye(Employe e);
	public List<Tache> getAllTacheByProjet(Projet p);


	
}
