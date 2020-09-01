package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.LocationRepository;
import com.intiformation.appAgenceImmo.modele.Location;

/**
 * Implémentation concrète de la couche service pour une location
 * 
 * @author hannahlevardon
 *
 */
@Service
public class LocationServiceImpl implements ILocationService {

	/* ___________ PROPRIETES __________ */

	/**
	 * Déclaration de la couche DAO
	 */
	@Autowired
	private LocationRepository locationRep;

	/**
	 * Setter pour injection bean Spring
	 * @param locationRep
	 */
	public void setLocationRep(LocationRepository locationRep) {
		this.locationRep = locationRep;
	}
	/*___________ METHODES __________*/

	/**
	 * Récupération de la liste de toutes les locations de la database
	 */
	@Override
	public List<Location> trouverTout() {
		return locationRep.findAll();
	}

	/**
	 * Récupération d'une location par son Id
	 */
	@Override
	public Location trouverViaId(Long pId) {
		return locationRep.findById(pId).get();
	}

	/**
	 * Récupération d'une référence d'une location
	 */
	@Override
	public Location trouverUn(Long pId) {
		return locationRep.getOne(pId);
	}

	/**
	 * Ajout d'une location dans la database
	 */
	@Override
	public Location ajouter(Location pLocation) {
		return locationRep.save(pLocation);
	}

	/**
	 * Modification d'une location dans la databse
	 */
	@Override
	public Location modifier(Location pLocation) {
		 return locationRep.save(pLocation);
	}

	/**
	 * Suppression d'une location de la databse
	 */
	@Override
	public void supprimer(Location pLocation) {
		locationRep.delete(pLocation);
	}

	/**
	 * Suppression d'une location de la databse à partir de son id
	 */
	@Override
	public void supprimerViaId(Long pId) {
		locationRep.deleteById(pId);
	}

	/**
	 * Trouver une liste de locations en fonction de la garniture : meublé ou non-meublé
	 */
	@Override
	public List<Location> trouverParFourniture(Boolean meuble) {
		return locationRep.findByMeuble(meuble);
	}


}// end classe
