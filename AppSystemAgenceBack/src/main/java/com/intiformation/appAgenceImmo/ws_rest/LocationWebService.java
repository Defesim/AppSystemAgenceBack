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

import com.intiformation.appAgenceImmo.modele.Location;
import com.intiformation.appAgenceImmo.service.ILocationService;

/**
 * Implémentation du Web Service Rest pour une location
 * 
 * URL de base : http://localhost:8080/gestion-agence-immo/location/*
 * 
 * @author hannahlevardon
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/location") // URL du WS REST 
public class LocationWebService {
	
	/*--------------- PROPRIETES ---------------*/

	// Déclaration de la couche service
	@Autowired
	private ILocationService locationService;

	/**
	 * Setter pour l'injection du bean Spring
	 * @param locationService
	 */
	public void setLocationService(ILocationService locationService) {
		this.locationService = locationService;
	}
	
	/*--------------- METHODES A EXPOSER DANS LE WEB SERVICE ---------------*/
	
	/**
	 * Méthode exposée dans le web service pour ajouter une location
	 * URL : http://localhost:8080/gestion-agence-immo/location/save
	 * @param pLocation
	 * @return
	 */
	@PostMapping(value="/save")
	public Location ajouterLocation(@RequestBody Location pLocation) {
		return locationService.ajouter(pLocation);
	}//end ajouterLocation
	
	/**
	 * Méthode exposée dans le web service pour trouver toutes les locations
	 * URL : http://localhost:8080/gestion-agence-immo/location/getAll
	 * @return
	 */
	@GetMapping(value="/getAll")
	public List<Location> trouverToutesLesLocations(){
		return locationService.trouverTout();
	}//end trouverToutesLesLocations
	
	/**
	 * Méthode exposée dans le web service pour une récupérer location via son Id
	 * URL : http://localhost:8080/gestion-agence-immo/location/findById/id
	 * @return
	 */
	@GetMapping(value="/findById/{id}")
	public Location trouverLocationParId(@PathVariable("id") Long pIdLocation) {
		return locationService.trouverViaId(pIdLocation);
	}//end trouverLocationParId
	
	
	/**
	 * Méthode exposée dans le web service pour modifier une location 
	 * URL : http://localhost:8080/gestion-agence-immo/location/findById/id
	 * @return
	 */
	@PutMapping(value="/update")
	public Location modifierLocation(@RequestBody Location pLocation) {
		return locationService.modifier(pLocation);
	}//end modifierLocation
	
	/**
	 * Méthode exposée dans le web service pour supprimer une location de la base de données
	 * URL : http://localhost:8080/gestion-agence-immo/location/delete/id
	 * @param pIdLocation
	 * @return
	 */
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> supprimerLocation(@PathVariable("id") Long pIdLocation){
		locationService.supprimerViaId(pIdLocation);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}//end supprimerLocation
	
	/**
	 * Méthode exposée dans le web service pour supprimer une location de la base de données
	 * URL : http://localhost:8080/gestion-agence-immo/location/getViaFourniture/ true or false
	 * @param pIdLocation
	 * @return
	 */
	@GetMapping(value="/getViaFourniture/{meuble}")
	public List<Location> trouverLocationViaFourniture(@PathVariable("meuble") boolean meuble){
		return locationService.trouverParFourniture(meuble);
	}//end trouverLocationViaFourniture
	
}//end classe














