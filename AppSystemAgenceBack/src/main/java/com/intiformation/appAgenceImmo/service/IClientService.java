package com.intiformation.appAgenceImmo.service;

import java.util.List;

import com.intiformation.appAgenceImmo.modele.Client;


/**
 * Interface de la couche service pour un client
 * 
 * @author anais
 *
 */
public interface IClientService extends IGenericService<Client> {
	
	// méthodes spécifiques pour un client
	
	// méthode pour trouver une personne via son nom
	public Client findByNom(String pNom); 
	
	
	// 1 méthode dans le repository => à controler avant de l'implementer 
	public List<Client> findByListeClassesStandardsInteretIdClasseStandard(Long pIdClasseStandard); 
	

}// end interface
