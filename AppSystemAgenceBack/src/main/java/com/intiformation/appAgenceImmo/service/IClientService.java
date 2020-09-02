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
	
	// méthode pour trouver un client via son nom
	public Client findByNom(String pNom); 
	
	// methode pour récup une liste des clients intéréssés par une classe Standard 
	public List<Client> findByListeClassesStandardsInteretIdClasseStandard(Long pIdClasseStandard);
	
	// meth pour récupérer le client qui a fait une acquisition
	public Client findByAcquisition(Long pIdAcquisition);
	

}// end interface
