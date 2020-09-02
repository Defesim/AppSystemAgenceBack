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

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.service.IAgentImmobilierService;

/**
 * implementation d'un ws rest pour un agent immobilier
 * 
 * ws rest sera accessible via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/
 * 
 * @author anais
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclare la classe comme WS rest
@RequestMapping("/ws-rest/agentImmobilier/") // URL du WS rest
public class AgentImmobilierWsREST {
	
	// déclaration de la couche service + injection de la couche avec spring
	@Autowired
	private IAgentImmobilierService agentImmobilierService;

	public void setAgentImmobilierService(IAgentImmobilierService agentImmobilierService) {
		this.agentImmobilierService = agentImmobilierService;
	}
	

	// ----------- Methodes à exposer dans le WS REST ----------------
	
		/** GET ALL
		 * ==========
		 * meth exposée dans le ws rest pour récup la liste des agents immobilier
		 * renvoie la liste des agents immobilier en JSON
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/getAll
		 * @return la liste des agents Immobilier
		 */
		@RequestMapping(value="/getAll", method=RequestMethod.GET)
		public List<AgentImmobilier> listAllAgentsImmobilierBdd(){
			
			return agentImmobilierService.trouverTout();
			
		}// end listAllAgentsImmobilierBdd
		

		
		/** ADD
		 * ======
		 * Méthode exposée dans le web service pour ajouter un agent Immobilier
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/save
		 */
		@PostMapping(value="/save")	
		public AgentImmobilier ajouterAgentImmobilier(@RequestBody AgentImmobilier pAgentImmobilier){
			return agentImmobilierService.ajouter(pAgentImmobilier);
		}//end ajouterAgentImmobilier

		
		/** GET BY ID
		 * ===========
		 * meth exposée dans le ws rest pour récup un Agent Immobilier via son id
		 * requete en GET 
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/get-by-id/<id-agent>
		 * @return le agent Immobilier
		 */
		@RequestMapping(value="/get-by-id/{id}", method=RequestMethod.GET)
		public AgentImmobilier agentImmobilierById(@PathVariable("id") Long pIdAgentImmobilier) {
			return agentImmobilierService.trouverViaId(pIdAgentImmobilier);
			
		}// end agentImmobilierById
		
		 
		/** UPDATE
		 * =========
		 * meth exposée dans le ws rest pour modifier un Agent Immobilier
		 * recoit les données en JSON et les transforme en java via Jackson
		 * la transaction est assurée par @ReqauestBody 
		 * requete en PUT
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/update/<id-agent>
		 */
		@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
		public void updateAgentImmobilier(@RequestBody AgentImmobilier pAgentImmobilier, @PathVariable("id") Long pIdAgentImmobilier) {
			agentImmobilierService.modifier(pAgentImmobilier);
			
		}// end updateAgentImmobilier
		

		/** DELETE
		 * =========
		 * meth exposée dans le ws rest pour supprimer un agent Immobilier via son id
		 * requete en GET 
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/delete/<id-agent>
		 * 
		 * @return
		 */
		@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Boolean> deleteAgentImmobilier(@PathVariable("id") Long pIdAgentImmobilier){
			
			// suppression de l'Agent Immobilier 
			agentImmobilierService.supprimerViaId(pIdAgentImmobilier);
			
			// config de la réponse à renvoyer 
			/**
			 * Boolean.TRUE ==> pour suppression OK 
			 * HttpStatus.OK ==> renvoi d'un 200 OK
			 */
			return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
			
		}// end deleteProprietaire
		
		
		
		/** GET BY NOM
		 * ============
		 * meth exposée dans le ws rest pour récup un agent immobilier via son nom
		 * requete en GET 
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/get-by-nom/<nom-agent>
		 * @return l'agent immo
		 */
		@RequestMapping(value="/get-by-nom/{nom}", method=RequestMethod.GET)
		public AgentImmobilier agentImmobiliertByNom(@PathVariable("nom") String pNomClient) {
			return agentImmobilierService.findByNom(pNomClient);
			
		}// end agentImmobiliertByNom
		
		
		/** Get Agent immobilier via Acquisition 
		 * =======================================
		 * meth exposée dans le ws rest pour récup un agent immobilier qui a réalisé une acquisition
		 * requete en GET 
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier/get-by-acquisition/<id-acquisition>
		 * @return l' agent immobilier
		 */
		@RequestMapping(value="/get-by-acquisition/{idAcquisition}", method=RequestMethod.GET)
		public AgentImmobilier agentImmobilierByAcquisition(@PathVariable("idAcquisition") Long pIdAcquisition) {
			
			return agentImmobilierService.findByAcquisition(pIdAcquisition);
			
		}// end agentImmobilierByAcquisition
		

}// end classe
