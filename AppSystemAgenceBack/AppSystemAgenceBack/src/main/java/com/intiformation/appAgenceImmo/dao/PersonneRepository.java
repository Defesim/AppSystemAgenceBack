package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.Personne;

/**
 * Implementation de la couche "DAO" pour une personne
 * implementation d'un ws REST pour une Personne
 * @author anais
 *
 */
@RepositoryRestResource
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer une personne avec son nom
	 * @param pNom
	 * @return Personne
	 */
	public Personne findByNom(String pNom); 

}// end interface
