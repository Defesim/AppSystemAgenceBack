package com.intiformation.appAgenceImmo.ws_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.appAgenceImmo.modele.Personne;
import com.intiformation.appAgenceImmo.service.IPersonneService;

/**
 * implementation d'un ws rest pour une personne
 * 
 * ws rest sera accessible via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/
 * 
 * @author anais
 *
 */
@RestController // déclare la classe comme WS rest
@RequestMapping("/ws-rest") // URL du WS rest
public class PersonneWsREST {
	
	// déclaration de la couche service + injection de la couche avec spring
	@Autowired
	private IPersonneService personneService;

	
	/**
	 * setter de la couche service pour injection spring 
	 * @param personneService
	 */
	public void setPersonneService(IPersonneService personneService) {
		this.personneService = personneService;
	}
	
	// ----------- Methodes à exposer dans le WS REST ----------------
	
	/**
	 * meth exposée dans le ws rest pour récup la liste des personnes
	 * renvoie la liste des personnes en JSON
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/getAll
	 * @return la liste des personnes
	 */
	@RequestMapping(value="/personnes/getAll", method=RequestMethod.GET)
	public List<Personne> listAllPersonneBdd(){
		
		return personneService.trouverTout();
		
	}// end listAllEmployesBdd
	
	

}// end class
