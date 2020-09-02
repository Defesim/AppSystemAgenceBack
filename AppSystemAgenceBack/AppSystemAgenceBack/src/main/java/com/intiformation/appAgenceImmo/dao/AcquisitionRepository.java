package com.intiformation.appAgenceImmo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.Acquisition;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;



/**
 * Implementation de la couche DAO pour une acquisition
 * implementation d'un ws REST pour une acquisition
 * @author hannahlevardon
 *
 */
@RepositoryRestResource // annotation d'un WS Rest
public interface AcquisitionRepository extends JpaRepository<Acquisition, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer une liste d'acquisitons à partir de l'id d'un client
	 * @param pClient
	 * @return liste d'acquisition
	 */
	 @Query("Select a From Acquisition a Where a.client.id_personne = :pIdClient")
	 public List<Acquisition> findByClientId(@Param("pIdClient")Long pIdClient);
	
	
	/**
	 * Méthode de requête qui permet de récupérer une liste d'acquisitons à partir d'un agent immobilier
	 * @param pAgent
	 * @return liste d'acquisition
	 */
	 @Query("Select a From Acquisition a Where a.agentImmobilier.id_personne = :pIdAgent")
	 public List<Acquisition> findByIdAgentImmobilier(@Param("pIdAgent")Long pIdAgent);
	
	/**
	 * Méthode de requête qui permet de récupérer une acquisiton à partir du bien
	 * @param pBien
	 * @return acquisition 
	 */
	public Acquisition findByBienImmobilierIdBienImmobilier(Long pBien);
	
	


}//end interface
