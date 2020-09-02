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

import com.intiformation.appAgenceImmo.modele.Client;
import com.intiformation.appAgenceImmo.service.IClientService;

/**
 * implementation d'un ws rest pour un client
 * 
 * ws rest sera accessible via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/
 * 
 * @author anais
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclare la classe comme WS rest
@RequestMapping("/ws-rest/clients") // URL du WS rest
public class ClientWsREST {
	
	// déclaration de la couche service + injection de la couche avec spring
	@Autowired
	private IClientService clientService;

	/**
	 * setter de la couche service pour injection spring 
	 * @param clientService
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	
	// ----------- Methodes à exposer dans le WS REST ----------------
	/** GET ALL
	 * ==========
	 * meth exposée dans le ws rest pour récup la liste des clients
	 * renvoie la liste des clients en JSON
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/getAll
	 * @return la liste des clients
	 */
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Client> listAllClientsBdd(){
		
		return clientService.trouverTout();
		
	}// end listAllClientsBdd
	
	
	/** ADD
	 * ======
	 * Méthode exposée dans le web service pour ajouter un client
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/save
	 */
	@PostMapping(value="/save")	
	public Client ajouterClient(@RequestBody Client pClient){
		return clientService.ajouter(pClient);
	}//end ajouterClient

	
	/** GET BY ID
	 * ===========
	 * meth exposée dans le ws rest pour récup un client via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/get-by-id/<id-client>
	 * @return la Personne
	 */
	@RequestMapping(value="/get-by-id/{id}", method=RequestMethod.GET)
	public Client clientById(@PathVariable("id") Long pIdClient) {
		return clientService.trouverViaId(pIdClient);
		
	}// end clientById
	
	 
	/** UPDATE
	 * =========
	 * meth exposée dans le ws rest pour modifier un client
	 * recoit les données en JSON et les transforme en java via Jackson
	 * la transaction est assurée par @ReqauestBody 
	 * requete en PUT
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/update/<id-client>
	 * @return
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public void updateClients(@RequestBody Client pClient, @PathVariable("id") Long pIdClient) {
		clientService.modifier(pClient);
		
	}// end updateClients
	

	/** DELETE
	 * =========
	 * meth exposée dans le ws rest pour supprimer un client via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/delete/<id-client>
	 * 
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteClient(@PathVariable("id") Long pIdClient){
		
		// suppression du client
		clientService.supprimerViaId(pIdClient);
		
		// config de la réponse à renvoyer 
		/**
		 * Boolean.TRUE ==> pour suppression OK 
		 * HttpStatus.OK ==> renvoi d'un 200 OK
		 */
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}// end deleteClient
	
	
	
	/** GET BY NOM
	 * ============
	 * meth exposée dans le ws rest pour récup un client via son nom
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/get-by-nom/<nom-client>
	 * @return le client
	 */
	@RequestMapping(value="/get-by-nom/{nom}", method=RequestMethod.GET)
	public Client clientByNom(@PathVariable("nom") String pNomClient) {
		return clientService.findByNom(pNomClient);
		
	}// end clientByNom
	
	
	
	/** Liste Clients pour une classeStandard d'interet
	 * ==================================================
	 * meth exposée dans le ws rest pour récup la liste des clients qui ont choisi une classe standard d'interet
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/get-by-CS/<id-CS>
	 * @return le client
	 */
	@RequestMapping(value="/get-by-CS/{id}", method=RequestMethod.GET)
	public List<Client> clientByCS(@PathVariable("id") Long pIdClasseStandard) {
		return clientService.findByListeClassesStandardsInteretIdClasseStandard(pIdClasseStandard);
		
	}// end clientByCS
	
	/** Get Client via Acquisition 
	 * ===========================
	 * meth exposée dans le ws rest pour récup du client qui a fait une acquisition
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/clients/get-by-acquisition/<id-acquisition>
	 * @return le client
	 */
	@RequestMapping(value="/get-by-acquisition/{idAcquisition}", method=RequestMethod.GET)
	public Client clientByAcquisition(@PathVariable("idAcquisition") Long pIdAcquisition) {
		
		return clientService.findByAcquisition(pIdAcquisition);
		
	}// end clientByAcquisition
	

}// end class 
