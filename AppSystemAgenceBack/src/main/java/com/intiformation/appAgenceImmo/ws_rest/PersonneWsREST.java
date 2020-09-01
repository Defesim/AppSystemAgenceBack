package com.intiformation.appAgenceImmo.ws_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.appAgenceImmo.modele.Personne;
import com.intiformation.appAgenceImmo.service.IPersonneService;


/**
 * implementation d'un ws rest pour une personne
 * 
 * ws rest sera accessible via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/
 * 
 * @author anais
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclare la classe comme WS rest
@RequestMapping("/ws-rest/personnes/") // URL du WS rest
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
	
	/** GET ALL
	 * ==========
	 * meth exposée dans le ws rest pour récup la liste des personnes
	 * renvoie la liste des personnes en JSON
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/getAll
	 * @return la liste des personnes
	 */
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Personne> listAllPersonneBdd(){
		
		return personneService.trouverTout();
		
	}// end listAllEmployesBdd
	
	
	/** ADD
	 * ======
	 * Méthode exposée dans le web service pour ajouter une personne
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/save
	 */
	@PostMapping(value="/save")	
	public Personne ajouterPersonne(@RequestBody Personne pPersonne){
		return personneService.ajouter(pPersonne);
	}//end ajouterPersonne

	
	/** GET BY ID
	 * ===========
	 * meth exposée dans le ws rest pour récup une personne via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/get-by-id/<id-personne>
	 * @return la Personne
	 */
	@RequestMapping(value="/get-by-id/{id}", method=RequestMethod.GET)
	public Personne personneById(@PathVariable("id") Long pIdPersonne) {
		return personneService.trouverViaId(pIdPersonne);
		
	}// end personneById
	
	 
	/** UPDATE
	 * =========
	 * meth exposée dans le ws rest pour modifier une personne
	 * recoit les données en JSON et les transforme en java via Jackson
	 * la transaction est assurée par @ReqauestBody 
	 * requete en PUT
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/update/<id-employe>
	 * @return
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public void updatePersonne(@RequestBody Personne pPersonne, @PathVariable("id") Long pIdPersonne) {
		personneService.modifier(pPersonne);
		
	}// end updatePersonne
	

	/** DELETE
	 * =========
	 * meth exposée dans le ws rest pour supprimer une personne via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/delete/<id-employe>
	 * 
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deletePersonne(@PathVariable("id") Long pIdPersonne){
		
		// suppression de la personne 
		personneService.supprimerViaId(pIdPersonne);
		
		// config de la réponse à renvoyer 
		/**
		 * Boolean.TRUE ==> pour suppression OK 
		 * HttpStatus.OK ==> renvoi d'un 200 OK
		 */
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}// end deletePersonne
	
	
	
	/** GET BY NOM
	 * ============
	 * meth exposée dans le ws rest pour récup une personne via son nom
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/personnes/get-by-nom/<nom-personne>
	 * @return la Personne
	 */
	@RequestMapping(value="/get-by-nom/{nom}", method=RequestMethod.GET)
	public Personne personneByNom(@PathVariable("nom") String pNomPersonne) {
		return personneService.findByNom(pNomPersonne);
		
	}// end personneByNom
	

}// end class
