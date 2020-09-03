package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;


/**
 * Implementation de la couche "DAO" pour un agent immobilier
 * implementation d'un ws REST pour un agent immobilier
 * @author anais
 *
 */
@RepositoryRestResource
public interface AgentImmobilierRepository extends JpaRepository<AgentImmobilier, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer l'agent immobilier avec son nom
	 * @param pNom
	 * @return  l'agent immobilier
	 */
	public AgentImmobilier findByNom(String pNom); 
	
	/**
	 * Méthode de requête qui permet de récupérer l'agent immobilier qui a réalisé une acquisition
	 * @param pIdAcquisition : id de l'acquisition
	 * @return l'agent immobilier
	 */
	public AgentImmobilier findByAcquisitionIdAcquisition(Long pIdAcquisition);


}// end interface
