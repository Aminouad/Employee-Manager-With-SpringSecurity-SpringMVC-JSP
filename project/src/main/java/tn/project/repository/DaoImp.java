package tn.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tn.project.model.Conge;
import tn.project.model.Employe;
import tn.project.model.Equipe;
import tn.project.model.Projet;
import tn.project.model.Tache;

@Repository
public class DaoImp implements IDao {

	
	@Autowired
	DataSource data;

	public void setData(DataSource data) {
		this.data = data;
	}
	
	
	
	
	
	@Override
	public void addProjet(Projet p) {
		// TODO Auto-generated method stub
     
		
		
try {
			
			Connection con=data.getConnection();
		    PreparedStatement pr=con.prepareStatement("insert into projet values(null,?,?,?,?)");
		    pr.setString(1,p.getNomPro());
		    pr.setString(2,p.getDescriptionPro());
		    pr.setInt(3,p.getChargeHorairePro());
		    pr.setInt(4, p.getEmploye().getId());
		    pr.executeUpdate();
		    

		}
			
			catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

	@Override
	public void addEmploye(Employe emp) {
		// TODO Auto-generated method stub
		
		try {
			
			Connection con=data.getConnection();
		    PreparedStatement pr=con.prepareStatement("insert into employe values(null,?,?,?,?,?)");
		    pr.setString(1,emp.getNomEmpl());
		    pr.setString(2,emp.getPrenomEmpl());
		    pr.setString(3,emp.getEmailEmpl());
		    pr.setString(4,emp.getDateNaissanceEmpl());

		    pr.setInt(5, emp.getEquipe().getIdEquipe());
		    pr.executeUpdate();
		    

		}
			
			catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void addEquipe(Equipe e) {
		// TODO Auto-generated method stub

		try {
			
			Connection con=data.getConnection();
		    PreparedStatement pr=con.prepareStatement("insert into equipe values(null,?,?)");
		    pr.setString(1,e.getNomEquipe());
		    pr.setString(2,e.getDescriptionEquipe());
		    pr.executeUpdate();
		    

		}
			
			catch (Exception ex) {
			// TODO: handle exception
		}
		
		
		
		
	}

	@Override
	public void addTache(Tache t) {
		// TODO Auto-generated method stub
try {
			
			Connection con=data.getConnection();
		    PreparedStatement pr=con.prepareStatement("insert into tache values(null,?,?,?,?,?,?,?,?)");
		    pr.setString(1,t.getDescriptionTache());
		    pr.setInt(2,t.getChargeHoraireTache());
		    pr.setInt(3,t.getPrioriteTache());
		    pr.setString(4,t.getStatusTache());
		    pr.setString(5,t.getDateDebutTache());
		    pr.setString(6,t.getDateFinTache());
		    pr.setInt(7,t.getEmploye().getId());
		    pr.setInt(8,t.getProjet().getIdPro());

		    pr.executeUpdate();
		    

		}
			
			catch (Exception ex) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Projet getProjetByEmploye(int idEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipe getEquipeById(int idEquipe) {
		// TODO Auto-generated method stub
		
		Equipe eq=null;
		try {
			
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from equipe where idEquipe="+idEquipe);
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				 eq=new Equipe(rs.getInt("idEquipe"),rs.getString("nomEquipe"),rs.getString("descriptionEquipe"));
		                      } }
			
			catch (Exception e2) {
				System.out.println("mochkla getEquipeById");
		}
		return eq;
		
		
		
	}

	@Override
	public List<Equipe> getAllEquipe() {
		
		List<Equipe> liste=null;
		try {
			liste= new ArrayList<Equipe>();
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from equipe");			
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Equipe eq= new Equipe(rs.getInt("idEquipe"), rs.getString("nomEquipe"), rs.getString("descriptionEquipe"));
				liste.add(eq);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return liste;
		
	}
	
	

	@Override
	public List<Projet> getAllProjetByEmploye(int idEmploye) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> getAllEmployeByEquipe(Equipe e) {
		
		
		List<Employe> le=null;
		
		try {
			le=new ArrayList<Employe>();
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from employe where idEquipe="+e.getIdEquipe());
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Employe emp=new Employe(rs.getInt("id"),rs.getString("nomEmpl"),rs.getString("prenomEmpl"),rs.getString("emailEmpl"),rs.getString("dateNaissanceEmpl"),e);
				le.add(emp);
			}
			
			
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("mochkla getAllEmployeByDepartement");
		}
		return le;
	}

	@Override
	public List<Projet> getAllProjet() {
		// TODO Auto-generated method stub
		
		
		
		List<Projet> liste=null;
		try {
			liste= new ArrayList<Projet>();
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from projet");			
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Projet p= new Projet(rs.getInt("idPro"), rs.getString("nomPro"), rs.getString("descriptionPro"),rs.getInt("chargeHorairePro"),getEmployeById(rs.getInt("idEmp")));
				liste.add(p);
			}
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return liste;
		
			}

	@Override
	public List<Employe> getAllEmploye() {
		
		List<Employe> liste=null;
		try {
			liste= new ArrayList<Employe>();
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from employe");			
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Employe emp= new Employe(rs.getInt("id"), rs.getString("nomEmpl"), rs.getString("prenomEmpl"),rs.getString("emailEmpl"),rs.getString("dateNaissanceEmpl"),getEquipeById(rs.getInt("idEquipe")));
				liste.add(emp);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return liste;
		
		
		
	}

	@Override
	public List<Conge> getAllCongeByEmploye(Employe e) {
List<Conge> lc=null;
		
		try {
			lc=new ArrayList<Conge>();
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from conge where idEmploye="+e.getId());
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Conge c=new Conge(rs.getInt("idConge"),rs.getString("dateD"),rs.getString("dateF"),getEmployeById(rs.getInt("idEmploye")));
				lc.add(c);
			}
			
			
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("mochkla getAllEmployeByDepartement");
		}
		return lc;
		
	}

	@Override
	public List<Tache> getAllTacheByEmploye(Employe e) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<Tache> getAllTacheByProjet(Projet p) {
		// TODO Auto-generated method stub
			
		
        List<Tache> lt=null;
		
		try {
			lt=new ArrayList<Tache>();
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from tache where idProjet="+p.getIdPro());
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Tache t=new Tache(rs.getInt("idTache"),rs.getString("descriptionTache"),rs.getInt("chargeHoraireTache"),rs.getInt("prioriteTache"),rs.getString("statusTache"),rs.getString("dateDebutTache"),rs.getString("dateFinTache"),getEmployeById(rs.getInt("idEmploye")),getProjetById(rs.getInt("idProjet")));
				lt.add(t);
			}
			
			
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("mochkla getAllEmployeByDepartement");
		}
		return lt;
		
	}





	@Override
	public Employe getEmployeById(int idEmp) {
		
		Employe emp=null;
		try {
			
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from employe where id="+idEmp);
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				 emp=new Employe(rs.getInt("id"), rs.getString("nomEmpl"), rs.getString("prenomEmpl"),rs.getString("emailEmpl"),rs.getString("dateNaissanceEmpl"),getEquipeById(rs.getInt("idEquipe")));
		                      } }
			
			catch (Exception e2) {
				System.out.println("mochkla getEmployeById");
		}
		return emp;
		
		
	}





	@Override
	public List<Tache> getAllTache() {
		// TODO Auto-generated method stub
		 List<Tache> lt=null;
			
			try {
				lt=new ArrayList<Tache>();
				Connection con=data.getConnection();
				PreparedStatement pr=con.prepareStatement("select * from tache");
				ResultSet rs=pr.executeQuery();
				while(rs.next()) {
					Tache t=new Tache(rs.getInt("idTache"),rs.getString("descriptionTache"),rs.getInt("chargeHoraireTache"),rs.getInt("prioriteTache"),rs.getString("statusTache"),rs.getString("dateDebutTache"),rs.getString("dateFinTache"),getEmployeById(rs.getInt("idEmploye")),getProjetById(rs.getInt("idProjet")));
					lt.add(t);
				}
				
				
				
			} catch (Exception ex) {
				// TODO: handle exception
				System.out.println("mochkla getAllTache");
			}
			return lt;
	}





	@Override
	public Projet getProjetById(int idProjet) {
		// TODO Auto-generated method stub
		Projet p=null;
		try {
			
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from projet where idPro="+idProjet);
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				p= new Projet(rs.getInt("idPro"), rs.getString("nomPro"), rs.getString("descriptionPro"),rs.getInt("chargeHorairePro"),getEmployeById(rs.getInt("idEmp")));

		                      } }
			
			catch (Exception e2) {
				System.out.println("mochkla getEquipeById");
		}
		return p;
		
		
	}





	@Override
	public void addConge(Conge c) {
		// TODO Auto-generated method stub
		
		
try {
			
			Connection con=data.getConnection();
		    PreparedStatement pr=con.prepareStatement("insert into conge values(null,?,?,?)");
		    pr.setString(1,c.getDateD());
		    pr.setString(2,c.getDateF());
		    pr.setInt(3,c.getEmpl().getId());
		    

		    pr.executeUpdate();
		    

		}
			
			catch (Exception ex) {
			// TODO: handle exception
		}
		
	}





	@Override
	public void deleteEquipe(Equipe e) {
		// TODO Auto-generated method stub
		try {
			
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("Delete from equipe where idEquipe="+e.getIdEquipe());
			pr.executeUpdate();
		}
			catch (Exception e2) {
				System.out.println(e.getIdEquipe());
		}
	}





	@Override
	public void deleteEmploye(Employe emp) {
		// TODO Auto-generated method stub
try {
			
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("Delete from employe where id="+emp.getId());
			pr.executeUpdate();
		}
			catch (Exception e2) {
				System.out.println(emp.getId());
		}
	}





	@Override
	public void deleteConge(Conge c) {
		// TODO Auto-generated method stub
		try {	Connection con=data.getConnection();
		PreparedStatement pr=con.prepareStatement("Delete from conge where idConge="+c.getIdConge());
		pr.executeUpdate();
	}
		catch (Exception e2) {
			System.out.println(c.getIdConge());
	}}
	





	@Override
	public void deleteTache(Tache t) {
		// TODO Auto-generated method stub
		try {	Connection con=data.getConnection();
		PreparedStatement pr=con.prepareStatement("Delete from tache where idTache="+t.getIdTache());
		pr.executeUpdate();
	}
		catch (Exception e2) {
			System.out.println(t.getIdTache());
	}
	}





	@Override
	public void deleteProjet(Projet p) {
		// TODO Auto-generated method stub
		try {	Connection con=data.getConnection();
		PreparedStatement pr=con.prepareStatement("Delete from projet where idPro="+p.getIdPro());
		pr.executeUpdate();
	}
		catch (Exception e2) {
			System.out.println(p.getIdPro());
	}
	}





	@Override
	public Conge getCongeById(int idC) {
		// TODO Auto-generated method stub
		Conge c=null;
		try {
			
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from conge where idConge="+idC);
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				c= new Conge(rs.getInt("idConge"), rs.getString("dateD"), rs.getString("dateF"),getEmployeById(rs.getInt("idEmploye")));

		                      } }
			
			catch (Exception e2) {
				System.out.println("mochkla getEquipeById");
		}
		
		
		return c;
	}





	@Override
	public Tache getTacheId(int idT) {
		// TODO Auto-generated method stub
		Tache t=null;
		try {
			
			Connection con=data.getConnection();
			PreparedStatement pr=con.prepareStatement("select * from tache where idTache="+idT);
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				 t=new Tache(rs.getInt("idTache"),rs.getString("descriptionTache"),rs.getInt("chargeHoraireTache"),rs.getInt("prioriteTache"),rs.getString("statusTache"),rs.getString("dateDebutTache"),rs.getString("dateFinTache"),getEmployeById(rs.getInt("idEmploye")),getProjetById(rs.getInt("idProjet")));

		                      } }
			
			catch (Exception e2) {
				System.out.println("mochkla getTacheById");
		}
		return t;
	}

}
