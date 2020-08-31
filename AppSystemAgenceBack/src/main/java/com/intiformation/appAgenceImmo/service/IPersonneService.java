package com.intiformation.appAgenceImmo.service;

import com.intiformation.appAgenceImmo.modele.Personne;

/**
 * Interface de la couche service pour une personne
 * 
 * @author anais
 *
 */
public interface IPersonneService extends IGenericService<Personne> {
	
	// méthodes spécifiques pour une personne
	
	// méthode pour trouver une personne via son nom
	public Personne findByNom(String pNom); 

}//end interface
