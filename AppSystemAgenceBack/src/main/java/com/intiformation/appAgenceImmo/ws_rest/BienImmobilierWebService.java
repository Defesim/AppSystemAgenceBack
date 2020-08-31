package com.intiformation.appAgenceImmo.ws_rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.service.IBienImmobillierService;



/**
 * http://localhost:8080/gestion-agence-immo/biensImmo/save
 * @author hannahlevardon
 *
 */
@RepositoryRestResource
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/biensImmo") // URL du WS REST pour des biens immobilier
public class BienImmobilierWebService {
	
	// Déclaration de la coucher service 
	@Autowired
	private IBienImmobillierService bienImmoService;

	/**
	 * Setter de la couche service pour permettre l'injection Spring
	 * @param bienImmoService
	 */
	public void setBienImmoService(IBienImmobillierService bienImmoService) {
		this.bienImmoService = bienImmoService;
	} 
	
	/*--------------- METHODES A EXPOSER DANS LE WEB SERVICE ---------------*/
	
	/**
	 * Méthode exposée dans le web service pour ajouter un bien immobilier
	 * URL: 
	 * 	http://localhost:8080/08_advanced_framework_springmvc/rest/employes/save
	 * @param pBien
	 * @return
	 */
	@PostMapping(value="/save")	
	public BienImmobilier ajouterBienImmobilier(@RequestBody BienImmobilier pBien){
		return bienImmoService.ajouter(pBien);
	}//end ajouterBienImmobilier

	
	

}//end class









