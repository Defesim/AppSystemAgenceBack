package com.intiformation.appAgenceImmo.ws_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.intiformation.appAgenceImmo.modele.AchatSaufTerrain;
import com.intiformation.appAgenceImmo.service.IAchatSaufTerrain;
import com.intiformation.appAgenceImmo.service.ILocationService;

/**
 * Implémentation du Web Service Rest pour une location
 * 
 * URL de base : http://localhost:8080/gestion-agence-immo/achatSaufTerrain/*
 * 
 * @author hannahlevardon
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/achatSaufTerrain") // URL du WS REST
public class AchatSaufTerrainWebService {

	/*--------------- PROPRIETES ---------------*/

	// Déclaration de la couche service
	@Autowired
	private IAchatSaufTerrain achatService;

	/**
	 * Setter pour l'injection du bean Spring
	 * 
	 * @param achatService
	 */
	public void setAchatService(IAchatSaufTerrain achatService) {
		this.achatService = achatService;
	}

	/*--------------- METHODES A EXPOSER DANS LE WEB SERVICE ---------------*/

	/**
	 * Méthode exposée dans le web service pour ajouter un achat Sauf Terrain 
	 * URL :
	 * http://localhost:8080/gestion-agence-immo/achatSaufTerrain/save
	 * 
	 * @param pLocation
	 * @return
	 */
	@PostMapping(value = "/save")
	public AchatSaufTerrain ajouterAchatST(@RequestBody AchatSaufTerrain pAchatST) {
		return achatService.ajouter(pAchatST);
	}
	
	/**
	 * Méthode exposée dans le web service pour trouver toutes les locations
	 * URL : http://localhost:8080/gestion-agence-immo/achatSaufTerrain/getAll
	 * @return
	 */
	@GetMapping(value="/getAll")
	public List<AchatSaufTerrain> trouverToutAchatST( ) {
		return achatService.trouverTout();
	}
	
	/**
	 * Méthode exposée dans le web service pour une récupérer location via son Id
	 * URL : http://localhost:8080/gestion-agence-immo/achatSaufTerrain/findById/id
	 * @return
	 */
	@GetMapping(value="/findById/{id}")
	public AchatSaufTerrain trouverToutAchatSTParId(@PathVariable("id") Long pIdAchatST) {	
		return achatService.trouverViaId(pIdAchatST);
	}
	
	/**
	 * Méthode exposée dans le web service pour modifier une location 
	 * URL : http://localhost:8080/gestion-agence-immo/achatSaufTerrain/findById/id
	 * @return
	 */
	@PutMapping(value="/update")
	public AchatSaufTerrain modifierAchatTS(@RequestBody AchatSaufTerrain pAchatST) {
		return achatService.modifier(pAchatST);
	}

	/**
	 * Méthode exposée dans le web service pour supprimer une location de la base de données
	 * URL : http://localhost:8080/gestion-agence-immo/achatSaufTerrain/delete/id
	 * @param pIdLocation
	 * @return
	 */
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> supprimerAchatTS(@PathVariable("id") Long pIdAchatTS){
		achatService.supprimerViaId(pIdAchatTS);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
}// end classe









