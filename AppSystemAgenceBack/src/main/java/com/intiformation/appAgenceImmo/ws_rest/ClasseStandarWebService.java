package com.intiformation.appAgenceImmo.ws_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
import com.intiformation.appAgenceImmo.modele.Personne;
import com.intiformation.appAgenceImmo.modele.Proprietaire;
import com.intiformation.appAgenceImmo.service.IClasseStandardService;

/**
 * Implémentation du Web Service Rest pour une classe Standard
 * 
 * URL de base : http://localhost:8080/gestion-agence-immo/classeStandard/*
 * 
 * @author hannahlevardon
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/classeStandard")
public class ClasseStandarWebService {

	/*--------------- PROPRIETES ---------------*/
	// Déclaration de la couche service
	@Autowired
	private IClasseStandardService classeStandardService;

	// Déclaration de la classe pour la config de l'id dans le ws rest
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	/**
	 * Déclaration des setter pour injection Spring 
	 * 
	 */
	public void setClasseStandardService(IClasseStandardService classeStandardService) {
		this.classeStandardService = classeStandardService;
	}

	public void setRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
		this.repositoryRestConfiguration = repositoryRestConfiguration;
	}
	
	/*--------------- METHODES A EXPOSER DANS LE WEB SERVICE ---------------*/
	
	/**
	 * Méthode exposée dans le WS pour ajouter une classe standard
	 * URL: http://localhost:8080/gestion-agence-immo/classeStandard/save
	 * @param pClasse
	 * @return la classe standard à ajouter 
	 */
	@PostMapping(value="save")
	public ClasseStandard ajouterClasseStandard(@RequestBody ClasseStandard pClasse) {
		return classeStandardService.ajouter(pClasse);
	}//end ajouterClasseStandard
	
	/**
	 * Méthode exposée dans le WS pour afficher la liste des toutes les classes standards
	 * URL: http://localhost:8080/gestion-agence-immo/classeStandard/getAll
	 * @return
	 */
	@GetMapping(value="getAll")
	public List<ClasseStandard> trouverToutesLesClasseStandards(){		
		return classeStandardService.trouverTout();	
	}//end trouverToutesLesClasseStandards
	
	/**
	 * Méthode exposée dans le WS pour afficher une classe standard via son Id
	 * URL: http://localhost:8080/gestion-agence-immo/classeStandard/findById/id-classe
	 * @return
	 */
	@GetMapping(value="/findById/{id}")
	public ClasseStandard trouverClasseStandardViaId(@PathVariable("id") Long idClasse) {
		
		//repositoryRestConfiguration.exposeIdsFor(ClasseStandard.class);	
		return classeStandardService.trouverViaId(idClasse);		
	}// end trouverClasseStandardViaId
	
	/**
	 * Méthode exposée dans le WS pour modifier une classe standard 
	 * URL: http://localhost:8080/gestion-agence-immo/classeStandard/update
	 * @param pClasse
	 * @return
	 */
	@PutMapping(value="/update")
	public ClasseStandard modifierClasseStandard(@RequestBody ClasseStandard pClasse) {
		return classeStandardService.modifier(pClasse);
	}//end modifierClasseStandard
	
	/**
	 * Méthode exposée dans le WS pour modifier une classe standard
	 * URL: http://localhost:8080/gestion-agence-immo/classeStandard/delete
	 * @param pIdClasse
	 * @return
	 */
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> supprimerClasseStandard(@PathVariable("id") Long pIdClasse ){		
		classeStandardService.supprimerViaId(pIdClasse);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);	
	}//end supprimerClasseStandard
	
	/**
	 * Méthode exposée dans le WS pour une liste de classes en fonction de l'usage
	 * URL: http://localhost:8080/gestion-agence-immo/classeStandard/usage/{usage}
	 * @param pIdClasse
	 * @return
	 */
	@GetMapping(value="/usage/{usage}")
	public List<ClasseStandard> trouverClasseParUsageDuBien(@PathVariable("usage") String pUsage){		
		return classeStandardService.trouverParUsageDuBien(pUsage);	
	}//end trouverClasseParUsageDuBien
	
	/**
	 * Méthode exposée dans le WS pour une liste de classes en fonction de l'usage
	 * URL: http://localhost:8080/gestion-agence-immo/classeStandard/type/{type}
	 * @param pIdClasse
	 * @return
	 */
	@GetMapping(value="/type/{type}")
	public List<ClasseStandard> trouverClasseParTypeDuBien(@PathVariable("type") String pType){		
		return classeStandardService.trouverParTypeDeBien(pType);
	}//end trouverClasseParUsageDuBien
	

}// end classe





















