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

import com.intiformation.appAgenceImmo.modele.AchatToutBien;
import com.intiformation.appAgenceImmo.modele.Location;
import com.intiformation.appAgenceImmo.service.IAchatToutBIen;

/**
 * Implémentation du Web Service Rest pour un achat de tout bien
 * 
 * URL de base : http://localhost:8080/gestion-agence-immo/achat/*
 * 
 * @author hannahlevardon
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/achat") // URL du WS REST 
public class AchatToutBienWebService {
	
	/*--------------- PROPRIETES ---------------*/

	// Déclaration de la couche service
	@Autowired
	private IAchatToutBIen achatService;

	/**
	 * Setter pour injection bean Spring
	 * @param achatService
	 */
	public void setAchatService(IAchatToutBIen achatService) {
		this.achatService = achatService;
	}
	
	/*--------------- METHODES A EXPOSER DANS LE WEB SERVICE ---------------*/

	/**
	 * Méthode exposée dans le web service pour ajouter un achat de tout bien 
	 * URL: http://localhost:8080/gestion-agence-immo/achat/save
	 * @param pAchatTB
	 * @return
	 */
	@PostMapping(value="/save")
	public AchatToutBien ajouterAchatTB(@RequestBody AchatToutBien pAchatTB) {
		return achatService.ajouter(pAchatTB);
	}//end ajouterAchatTB
	
	/**
	 * Méthode exposée dans le web service pour trouver toutes les achats
	 * URL : http://localhost:8080/gestion-agence-immo/achat/getAll
	 * @return
	 */
	@GetMapping(value="/getAll")
	public List<AchatToutBien> trouverToutesLesAchatsTB(){
		return achatService.trouverTout();
	}//end trouverToutesLesLocations
	
	/**
	 * Méthode exposée dans le web service pour une récupérer location via son Id
	 * URL : http://localhost:8080/gestion-agence-immo/achat/findById/id
	 * @return
	 */
	@GetMapping(value="/findById/{id}")
	public AchatToutBien trouverAchatTBParId(@PathVariable("id") Long pIdAchat) {
		return achatService.trouverViaId(pIdAchat);
	}//end trouverAchatTBParId
	
	/**
	 * Méthode exposée dans le web service pour modifier un achat TB 
	 * URL : http://localhost:8080/gestion-agence-immo/location/achat/id
	 * @return
	 */
	@PutMapping(value="/update")
	public AchatToutBien modifierAchatTB(@RequestBody AchatToutBien pAchatTB) {
		return achatService.modifier(pAchatTB);
	}//end modifierAchatTB
	
	/**
	 * Méthode exposée dans le web service pour supprimer une location de la base de données
	 * URL : http://localhost:8080/gestion-agence-immo/location/delete/id
	 * @param pIdLocation
	 * @return
	 */
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> supprimerAchatTB(@PathVariable("id") Long pIdAchat){
		achatService.supprimerViaId(pIdAchat);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}// end supprimerAchatTB

}//end classe

















