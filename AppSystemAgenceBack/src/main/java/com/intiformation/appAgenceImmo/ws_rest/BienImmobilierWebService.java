package com.intiformation.appAgenceImmo.ws_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
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
//@RepositoryRestResource
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/biensImmo") // URL du WS REST pour des biens immobilier
public class BienImmobilierWebService {

	// Déclaration de la coucher service
	@Autowired
	private IBienImmobillierService bienImmoService;

	// Déclaration de la classe pour la config de l'id dans le ws rest
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	

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
	 * 	
	 * @param pBien
	 * @return
	 */
	@PostMapping(value="/save")	
	public BienImmobilier ajouterBienImmobilier(@RequestBody BienImmobilier pBien){
		return bienImmoService.ajouter(pBien);
	}//end ajouterBienImmobilier

	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value="/getAll")	
	public List<BienImmobilier> trouverTousBienImmobiliers(){
		
		repositoryRestConfiguration.exposeIdsFor(BienImmobilier.class);
		
		return bienImmoService.trouverTout() ;
	}// end trouverTousBienImmobiliers
	
	

}// end class
