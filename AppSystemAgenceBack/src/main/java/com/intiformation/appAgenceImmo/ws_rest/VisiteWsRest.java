package com.intiformation.appAgenceImmo.ws_rest;

import java.util.Date;
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

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;
import com.intiformation.appAgenceImmo.modele.Visite;
import com.intiformation.appAgenceImmo.service.IAgentImmobilierService;
import com.intiformation.appAgenceImmo.service.IBienImmobillierService;
import com.intiformation.appAgenceImmo.service.IClientService;
import com.intiformation.appAgenceImmo.service.IVisiteService;

/**
 * implementation d'un ws rest pour une visite
 * 
 * ws rest sera accessible via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/
 * 
 * @author anais
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclare la classe comme WS rest
@RequestMapping("/ws-rest/visites/") // URL du WS rest
public class VisiteWsRest {
	
	// déclaration de la couche service + injection de la couche avec spring
	@Autowired
	private IVisiteService visiteService;
	
	@Autowired
	private IClientService clientService;

	@Autowired
	private IAgentImmobilierService agentImmobilierService;
	
	@Autowired
	private IBienImmobillierService bienImmobillierService;

	/**
	 * setter de la couche service pour injection spring 
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public void setBienImmobillierService(IBienImmobillierService bienImmobillierService) {
		this.bienImmobillierService = bienImmobillierService;
	}

	public void setVisiteService(IVisiteService visiteService) {
		this.visiteService = visiteService;
	}
	
	public void setAgentImmobilierService(IAgentImmobilierService agentImmobilierService) {
		this.agentImmobilierService = agentImmobilierService;
	}
	
	
	
	// ----------- Methodes à exposer dans le WS REST ----------------
	
	/** GET ALL
	 * ==========
	 * meth exposée dans le ws rest pour récup la liste des visites
	 * renvoie la liste des visites en JSON
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/getAll
	 * @return la liste des visites
	 */
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Visite> listAllVisitesBdd(){
		
		return visiteService.trouverTout();
		
	}// end listAllVisitesBdd
	
	
	/** ADD
	 * ======
	 * Méthode exposée dans le web service pour ajouter une visite
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/save
	 */
	@PostMapping(value="/save")	
	public Visite ajouterVisite(@RequestBody Visite pVisite){
		return visiteService.ajouter(pVisite);
	}//end ajouterVisite

	
	/** GET BY ID
	 * ===========
	 * meth exposée dans le ws rest pour récup une visite via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/get-by-id/<id-visite>
	 * @return la visite
	 */
	@RequestMapping(value="/get-by-id/{id}", method=RequestMethod.GET)
	public Visite visiteById(@PathVariable("id") Long pIdVisite) {
		return visiteService.trouverViaId(pIdVisite);
		
	}// end visiteById
	
	 
	/** UPDATE
	 * =========
	 * meth exposée dans le ws rest pour modifier une visite
	 * recoit les données en JSON et les transforme en java via Jackson
	 * la transaction est assurée par @ReqauestBody 
	 * requete en PUT
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/update/<id-visite>
	 * @return
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public void updateVisite(@RequestBody Visite pVisite, @PathVariable("id") Long pIdVisite) {
		visiteService.modifier(pVisite);
		
	}// end updateVisite
	

	/** DELETE
	 * =========
	 * meth exposée dans le ws rest pour supprimer une visite via son id
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/delete/<id-visite>
	 * 
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteVisite(@PathVariable("id") Long pIdVisite){
		
		// suppression de la visite
		visiteService.supprimerViaId(pIdVisite);
		
		// config de la réponse à renvoyer 
		/**
		 * Boolean.TRUE ==> pour suppression OK 
		 * HttpStatus.OK ==> renvoi d'un 200 OK
		 */
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}// end deleteClient
	
	
	
	/** LISTE DES VISITES PAR DATE 
	 * ============================
	 * meth exposée dans le ws rest pour récupérer la liste de visites pour une date spécifique
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/get-by-date/<date>
	 * @param pDate
	 * @return liste des visites de la date 
	 */
// NE FONCTIONNE PAS 
	@RequestMapping(value="/get-by-date/{date}", method=RequestMethod.GET)
	public List<Visite> findByDateVisite(@PathVariable("date") Date pDate){
		return visiteService.trouverParDateVisite(pDate);
		
	}// end findByDateVisite
	
	/** LISTE DES VISITES PAR CLIENT 
	 * ==============================
	 * meth exposée dans le ws rest pour récupérer la liste de visites pour un client
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/get-by-client/<id-client>
	 * @return liste des visites du client
	 */
	@RequestMapping(value="/get-by-client/{id}", method=RequestMethod.GET)
	public List<Visite> findByClient(@PathVariable("id") Long pIdClient) {
		
		Client client = clientService.trouverViaId(pIdClient);
		
		return visiteService.trouverParClient(client);
		
	}// end findByClient
	
	
	/** LISTE DES VISITES PAR AGENT IMMOBILIER 
	 * ========================================
	 * meth exposée dans le ws rest pour récupérer la liste de visites d'un agent immobilier
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/get-by-agent/<id-agent>
	 * @return liste des visites de l'agent immobilier
	 */
	@RequestMapping(value="/get-by-agent/{id}", method=RequestMethod.GET)
	public List<Visite> findByAgentImmobilier(@PathVariable("id") Long pIdAgent){
		
		AgentImmobilier agentImmobilier = agentImmobilierService.trouverViaId(pIdAgent);
		
		return visiteService.trouverParAgentImmobilier(agentImmobilier);
		
	}// end findByAgentImmobilier
	
	
	/** LISTE DES VISITES PAR BIEN IMMOBILIER 
	 * ========================================
	 * meth exposée dans le ws rest pour récupérer une liste des visite d'un bien immobilier
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/get-by-bien/<id-bien>
	 * @return liste des visite du bien immobilier 
	 */
	@RequestMapping(value="/get-by-bien/{id}", method=RequestMethod.GET)
	public List<Visite> findByBienImmobilier(@PathVariable("id") Long pBien){
		
		BienImmobilier bienImmobilier = bienImmobillierService.trouverViaId(pBien);
		
		return visiteService.trouverParBienImmobilier(bienImmobilier);
		
	}// end findByBienImmobilier
	
	/** LISTE DES VISITES PAR BIEN IMMOBILIER & AGENT IMMO
	 * ====================================================
	 * meth exposée dans le ws rest pour récupérer une liste des visite d'un agent immobilier en fonction du bien visité
	 * requete en GET 
	 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/visites/get-bien-agent/<id-bien>/<id-agent>
	 * @return liste des visites de l'agent immobilier pour un bien immobilier
	 */
	@RequestMapping(value="/get-bien-agent/{idBien}/{idAgent}", method=RequestMethod.GET)
	public List<Visite> findByAgentImmobilierAndBienImmobilier(@PathVariable("idBien") Long pIdBien, @PathVariable("idAgent") Long pIdAgent){
		
		BienImmobilier bienImmobilier = bienImmobillierService.trouverViaId(pIdBien);
		AgentImmobilier agentImmobilier = agentImmobilierService.trouverViaId(pIdAgent);
		
		return visiteService.trouverParAgentImmobilierAndBienImmobilier(agentImmobilier, bienImmobilier);
		
	}// end findByAgentImmobilierAndBienImmobilier
	
	
	
	/** LISTE DES VISITES PAR BIEN IMMOBILIER & DATE
	 * =============================================
	 * Méthode de requête qui permet de récupérer une liste des visite d'un bien immobilier en fonction de la date
	 * @param pBien
	 * @param pDate
	 * @return liste des visite du bien immobilier pour une date 
	 */
	// A FAIRE
	//public List<Visite> findByBienImmobilierAndDateVisite(BienImmobilier pBien, Date pDate);
	
	/** LISTE DES VISITES PAR AGENT IMMOBILIER & DATE
	 * ==============================================
	 * Méthode de requête qui permet de récupérer une liste des visite d'un agent immobilier en fonction de la date
	 * @param pAgent
	 * @param pDate
	 * @return liste des visites de l'agent immobilier pour une date 
	 */
	// A FAIRE
	//public List<Visite> findByAgentImmobilierAndDateVisite(AgentImmobilier pAgent, Date pDate);
	

	

}// end classe
