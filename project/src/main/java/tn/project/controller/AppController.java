package tn.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.project.model.Conge;
import tn.project.model.Employe;
import tn.project.model.Equipe;
import tn.project.model.Projet;
import tn.project.model.Tache;
import tn.project.repository.DaoImp;
import tn.project.repository.IDao;

@Controller
public class AppController {
	
	@Autowired
	IDao dao;
	
	
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	
	
	
	
	@GetMapping("/FormAjoutEquipe")
	public String AddEquipe(Model m) {
		Equipe equipe=new Equipe();
		m.addAttribute("equipe",equipe);
		        
		return "FormAjoutEquipe";
	}
	@PostMapping("/saveEquipe")
	public String get3(Model m, @ModelAttribute("equipe") Equipe equipe) {
		dao.addEquipe(equipe);
		return "redirect:/";
	}
	
	
	@GetMapping("/Employe/{idEquipe}")
	public String getEmp(Model m,@PathVariable("idEquipe") int idEquipe){
		Equipe equipe=new Equipe();
		equipe=dao.getEquipeById(idEquipe);
		List<Employe> liste= dao.getAllEmployeByEquipe(equipe);
		m.addAttribute("liste",liste);
		m.addAttribute("equipe",equipe);
		return "Employe";
	}
	
	@GetMapping("Employe/Employe/{idEquipe}/Conge/{id}")
	public String getConge(Model m,@PathVariable("idEquipe") int idEquipe,@PathVariable("id") int id){
		Employe emp=new Employe();
		emp=dao.getEmployeById(id);
		List<Conge> listeC= dao.getAllCongeByEmploye(emp);
		m.addAttribute("listeC",listeC);
		m.addAttribute("emp",emp);
		return "Conge";
	}
	
	
	
	@GetMapping("/addEmploye")
	public String AddEmpl(Model m) {
		Employe emp=new Employe();
		m.addAttribute("emp",emp);
		List<Equipe> liste= dao.getAllEquipe();
		m.addAttribute("liste",liste);
		return "FormAjoutEmploye";
	}
	@PostMapping("/saveEmploye")
	public String get3(Model m, @ModelAttribute("emp") Employe emp) {
		dao.addEmploye(emp);
		return "redirect:/";
	}
	
	
	
	
	
	@GetMapping("/FormAjoutProjet")
	public String addProjet(Model m) {
        Projet p=new Projet();
		m.addAttribute("p",p);
		List<Employe> liste= dao.getAllEmploye();
		m.addAttribute("liste",liste);
		return "FormAjoutProjet";
	}
	@PostMapping("/saveProjet")
	public String get4(Model m, @ModelAttribute("p") Projet p) {
		dao.addProjet(p);
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/")
	public String showHome(Model m) {
		List<Equipe> liste= dao.getAllEquipe();
		m.addAttribute("liste",liste);
		return "home";
	}
	@GetMapping("/Taches")
	public String showTaches(Model m) {
		
		List<Tache> liste2= dao.getAllTache();
		m.addAttribute("liste2",liste2);
		return "Taches";
	}
	
	@GetMapping("/Projets")
	public String showProjets(Model m) {
		
		List<Projet> liste1= dao.getAllProjet();
		m.addAttribute("liste1",liste1);
		return "Projets";
	}
	
	
	
	// add request mapping for /systems 
	
		@GetMapping("/gestion")
		public String showSystems() {
			
			return "gestion";
		}
		
		@GetMapping("/FormAjoutTache")
		public String addTache(Model m) {
	        Tache t=new Tache();
			m.addAttribute("t",t);
			List<Employe> liste= dao.getAllEmploye();
			m.addAttribute("liste",liste);
			List<Projet> liste1= dao.getAllProjet();
			m.addAttribute("liste1",liste1);
			return "FormAjoutTache";
		}
		
		@PostMapping("/saveTache")
		public String get9(Model m, @ModelAttribute("t") Tache t) {
			dao.addTache(t);
			return "redirect:/";
		}
		
		@GetMapping("/FormAjoutConge")
		public String addConge(Model m) {
	        Conge c=new Conge();
			m.addAttribute("c",c);
			List<Employe> liste= dao.getAllEmploye();
			m.addAttribute("liste",liste);
			return "FormAjoutConge";
		}
		@PostMapping("/saveConge")
		public String get8(Model m, @ModelAttribute("C") Conge c) {
			dao.addConge(c);
			return "redirect:/";
		}
		@GetMapping("/deleteEquipe/{idEquipe}")
        public String deleteEq(Model m,@PathVariable("idEquipe") int idEquipe) {
			Equipe equipe=new Equipe();
			equipe=dao.getEquipeById(idEquipe);
			dao.deleteEquipe(equipe);    
			
			return "redirect:/";
		}
		
		
		@GetMapping("/Employe/deleteEmploye/{id}")
        public String deleteEmp(Model m,@PathVariable("id") int id) {
			Employe emp=new Employe();
			emp=dao.getEmployeById(id);
			dao.deleteEmploye(emp);    
			
			return "redirect:/";
		
}
		@GetMapping("/Taches/deleteTache/{idTache}")
        public String deleteTache(Model m,@PathVariable("idTache") int idTache) {
			Tache t=new Tache();
			t=dao.getTacheId(idTache);
			dao.deleteTache(t);    
			
			return "redirect:/";
		
}

		
		@GetMapping("Employe/Employe/{idEquipe}/Conge/deleteConge/{idConge}")
        public String deleteCon(Model m,@PathVariable("idConge") int idConge) {
			Conge c=new Conge();
			c=dao.getCongeById(idConge);
			dao.deleteConge(c);    
			
			return "redirect:/";
		

}
		
		@GetMapping("Projets/deleteProjet/{idPro}")
        public String deletePro(Model m,@PathVariable("idPro") int idPro) {
			Projet p=new Projet();
			p=dao.getProjetById(idPro);
			dao.deleteProjet(p);    
			
			return "redirect:/";
		

}



}
