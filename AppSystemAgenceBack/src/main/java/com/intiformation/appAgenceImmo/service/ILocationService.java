package com.intiformation.appAgenceImmo.service;

import java.util.List;

import com.intiformation.appAgenceImmo.modele.Location;

/**
 * Interface de la couche service pour une acquisition
 * Contient des méthodes spécifiques
 * @author hannahlevardon
 *
 */
public interface ILocationService extends IGenericService<Location> {
	
	public List<Location> trouverParFourniture (Boolean meuble);

}//end interface
