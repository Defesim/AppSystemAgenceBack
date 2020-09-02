package com.intiformation.appAgenceImmo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;
import com.intiformation.appAgenceImmo.modele.Visite;

/**
 * Implementation de la couche "DAO" pour une visite
 * implementation d'un ws REST pour une visite
 * @author anais
 *
 */
@RepositoryRestResource
public interface VisiteRepository  extends JpaRepository<Visite, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer la liste de visites pour une date spécifique
	 * @param pDate
	 * @return liste des visites de la date 
	 */
	public List<Visite> findByDateVisite(Date pDate); 
	
	/**
	 * Méthode de requête qui permet de récupérer la liste de visites pour un client
	 * @param pClient
	 * @return liste des visites du client
	 */
	public List<Visite> findByClient(Client pClient); 
	
	/**
	 * Méthode de requête qui permet de récupérer une liste des visite d'un agent immobilier
	 * @param pAgent
	 * @return liste des visites de l'agent immobilier
	 */
	public List<Visite> findByAgentImmobilier(AgentImmobilier pAgent);
	
	/**
	 * Méthode de requête qui permet de récupérer une liste des visite d'un bien immobilier
	 * @param pBien
	 * @return liste des visite du bien immobilier 
	 */
	public List<Visite> findByBienImmobilier(BienImmobilier pBien);
	
	/**
	 * Méthode de requête qui permet de récupérer une liste des visite d'un bien immobilier en fonction de la date
	 * @param pBien
	 * @param pDate
	 * @return liste des visite du bien immobilier pour une date 
	 */
	public List<Visite> findByBienImmobilierAndDateVisite(BienImmobilier pBien, Date pDate);
	
	/**
	 * Méthode de requête qui permet de récupérer une liste des visite d'un agent immobilier en fonction de la date
	 * @param pAgent
	 * @param pDate
	 * @return liste des visites de l'agent immobilier pour une date 
	 */
	public List<Visite> findByAgentImmobilierAndDateVisite(AgentImmobilier pAgent, Date pDate);
	
	/**
	 * Méthode de requête qui permet de récupérer une liste des visite d'un agent immobilier en fonction du bien visité
	 * @param pAgent
	 * @param pBien
	 * @return liste des visites de l'agent immobilier pour un bien immobilier
	 */
	public List<Visite> findByAgentImmobilierAndBienImmobilier(AgentImmobilier pAgent, BienImmobilier pBien);

}// end interface
