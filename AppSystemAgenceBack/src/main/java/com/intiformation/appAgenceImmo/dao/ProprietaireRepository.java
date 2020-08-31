package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Proprietaire;

/**
 * Implementation de la couche "DAO" pour un proprietaire
 * implementation d'un ws REST pour un proprietaire
 * @author anais
 *
 */
@RepositoryRestResource
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
	
	
	/**
	 * Méthode de requête qui permet de récupérer le propriétaire d'un bien immobilier
	 * @param pBien
	 * @return le Proprietaire du bien 
	 */
	public Proprietaire findByBienImmobilier(BienImmobilier pBien);
	
	

}// end interface
