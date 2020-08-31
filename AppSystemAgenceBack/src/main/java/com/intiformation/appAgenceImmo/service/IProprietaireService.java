package com.intiformation.appAgenceImmo.service;

import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Proprietaire;

/**
 * Interface de la couche service pour un proprietaire
 * 
 * @author anais
 *
 */
public interface IProprietaireService extends IGenericService<Proprietaire>{
	
	// méthodes spécifiques pour un proprietaire
	
	/**
	 * permet de récupérer le propriétaire d'un bien immobilier
	 */
	public Proprietaire TrouverParLeBienDuProprio(BienImmobilier pBien);

}// end interface
