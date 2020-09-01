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

import com.intiformation.appAgenceImmo.modele.Acquisition;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;
import com.intiformation.appAgenceImmo.service.IAcquisitionService;

/**
 * Implémentation du Web Service Rest pour une acquisition
 * 
 * URL de base : http://localhost:8080/gestion-agence-immo/acquisition/*
 * 
 * @author hannahlevardon
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/acquisition") // URL du WS REST 
public class AcquistionWebService {

	/*--------------- PROPRIETES ---------------*/

	// Déclaration de la couche service
	@Autowired
	private IAcquisitionService acquistionService;

	// Déclaration de la classe pour la config de l'id dans le ws rest
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	/**
	 * Setter de la couche service pour injection Spring
	 * @param acquistionService
	 */
	public void setAcquistionService(IAcquisitionService acquistionService) {
		this.acquistionService = acquistionService;
	}

	public void setRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
		this.repositoryRestConfiguration = repositoryRestConfiguration;
	}
	
	/*--------------- METHODES A EXPOSER DANS LE WEB SERVICE ---------------*/
	
	/**
	 * Méthode exposée dans le web service pour ajouter une acquisition
	 * URL : http://localhost:8080/gestion-agence-immo/acquisition/save
	 * @param pBien
	 * @return
	 */
	@PostMapping(value="/save")
	public Acquisition ajouterAcquisition(@RequestBody Acquisition pAcquisition) {
		return acquistionService.ajouter(pAcquisition);
	}// end ajouterAcquisition
	
	/**
	 * Méthode exposée dans le web service pour récupérer la liste des acquisitions
	 * URL : http://localhost:8080/gestion-agence-immo/acquisition/getAll
	 * @return
	 */
	@GetMapping(value="/getAll")
	public List<Acquisition> trouverToutesLesAcquisition(){		
		return acquistionService.trouverTout();	
	}//end trouverToutesLesAcquisition
	
	/**
	 * Méthode exposée dans le web service pour récupérer une acquisition via son Id
	 * URL : http://localhost:8080/gestion-agence-immo/acquisition/findById/id-acquisition
	 * @return
	 */
	@GetMapping(value="/findById/{id}")
	public Acquisition trouverAcquisitionViaId(@PathVariable("id") Long idAcquisition) {
		return acquistionService.trouverViaId(idAcquisition);
	}// end trouverAcquisitionViaId

	/**
	 * Méthode exposée dans le web service pour modifier une acquisition 
	 * URL : http://localhost:8080/gestion-agence-immo/acquisition/update
	 * @return
	 */
	@PutMapping(value="/update")
	public Acquisition modifierAcquisition(@RequestBody Acquisition pAcquisition ) {
		return acquistionService.modifier(pAcquisition);
	}//end modifierAcquisition
	

	/**
	 * Méthode exposée dans le web service pour supprimer une acquisition  via son id
	 * URL : http://localhost:8080/gestion-agence-immo/acquisition/delete/id
	 * @return
	 */
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> supprimerAcquisition(@PathVariable("id") Long pId){
		acquistionService.supprimerViaId(pId);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);		
	}//end supprimerAcquisition 
	
	
	/**
	 * Méthode exposée dans le web service pour récupérer une liste d'acquisition via l'id d'un client
	 * http://localhost:8080/gestion-agence-immo/acquisition/getByClient/ 
	 * @param pClient
	 * @return
	 */
	@GetMapping(value="getByClient/{idClient}")
	public List<Acquisition> trouverAcquisitionsDuClient(@PathVariable("idClient") Long pIdClient){
		return acquistionService.trouverParIdClient(pIdClient);
	}

	
}// end classe




























