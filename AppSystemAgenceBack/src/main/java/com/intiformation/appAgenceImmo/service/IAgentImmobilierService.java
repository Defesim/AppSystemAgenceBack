package com.intiformation.appAgenceImmo.service;

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;


/**
 * Interface de la couche service pour un agent immobilier
 * 
 * @author anais
 *
 */
public interface IAgentImmobilierService extends IGenericService<AgentImmobilier> {
	
	// méthodes spécifiques pour un agent immobilier
	
	// méthode pour trouver un Agent Immobilier via son nom
	public AgentImmobilier findByNom(String pNom); 
	
	// meth pour récupérer l'Agent Immobilier qui a réalisé une acquisition
	public AgentImmobilier findByAcquisition(Long pIdAcquisition);
	
	// méthode pour trouver un Agent Immobilier via son email
	public AgentImmobilier findByMail(String pMail); 

}// end interface
