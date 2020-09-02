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

import com.intiformation.appAgenceImmo.modele.Adresse;
import com.intiformation.appAgenceImmo.service.IAdresseService;

/**
 * implementation d'un ws rest pour l'adresse
 * 
 * ws rest sera accessible via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/adresse/
 * 
 * @author anais
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclare la classe comme WS rest
@RequestMapping("/ws-rest/adresse/") // URL du WS rest
public class AdresseWsRest {
	
	// déclaration de la couche service + injection de la couche avec spring
	@Autowired
	private IAdresseService adresseService;

	public void setAdresseService(IAdresseService adresseService) {
		this.adresseService = adresseService;
	}
	

	// ----------- Methodes à exposer dans le WS REST ----------------
	

	/** GET ALL
	 * ==========
	 * meth exposée dans le ws rest pour récup la liste des adresses
	 * renvoie la liste des adresses immobilier en JSON
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/adresse/getAll
	 * @return la liste des adresses
	 */
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Adresse> listAllAdressesBdd(){
		
		return adresseService.trouverTout();
		
	}// end listAllAdressesBdd
	

	
	/** ADD
	 * ======
	 * Méthode exposée dans le web service pour ajouter une adresse
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/adresse/save
	 */
	@PostMapping(value="/save")	
	public Adresse ajouterAdresse(@RequestBody Adresse pAdresse){
		return adresseService.ajouter(pAdresse);
	}//end ajouterAdresse

	
	/** GET BY ID
	 * ===========
	 * meth exposée dans le ws rest pour récup une Adresse via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/adresse/get-by-id/<id-adresse>
	 * @return l'adresse
	 */
	@RequestMapping(value="/get-by-id/{id}", method=RequestMethod.GET)
	public Adresse adresseById(@PathVariable("id") Long pIdAdresse) {
		return adresseService.trouverViaId(pIdAdresse);
		
	}// end adresseById
	
	 
	/** UPDATE
	 * =========
	 * meth exposée dans le ws rest pour modifier une adresse
	 * recoit les données en JSON et les transforme en java via Jackson
	 * la transaction est assurée par @ReqauestBody 
	 * requete en PUT
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/adresse/update/<id-adresse>
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public void updateAdresse(@RequestBody Adresse pAdresse, @PathVariable("id") Long pIdAdresse) {
		adresseService.modifier(pAdresse);
		
	}// end updateAdresse
	

	/** DELETE
	 * =========
	 * meth exposée dans le ws rest pour supprimer une adresse via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/adresse/delete/<id-adresse>
	 * 
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAdresse(@PathVariable("id") Long pIdAdresse){
		
		// suppression de l'adresse
		adresseService.supprimerViaId(pIdAdresse);
		
		// config de la réponse à renvoyer 
		/**
		 * Boolean.TRUE ==> pour suppression OK 
		 * HttpStatus.OK ==> renvoi d'un 200 OK
		 */
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}// end deleteAdresse
	

}// end classe
