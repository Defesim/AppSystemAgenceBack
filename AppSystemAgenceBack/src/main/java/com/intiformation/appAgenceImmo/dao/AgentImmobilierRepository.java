package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.Visite;

/**
 * Implementation de la couche "DAO" pour un agent immobilier
 * implementation d'un ws REST pour un agent immobilier
 * @author anais
 *
 */
@RepositoryRestResource
public interface AgentImmobilierRepository extends JpaRepository<AgentImmobilier, Long> {
	
	

}// end interface
