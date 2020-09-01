package com.intiformation.appAgenceImmo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.Client;

/**
 * Implementation de la couche "DAO" pour un client
 * implementation d'un ws REST pour  un client
 * @author anais
 *
 */
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer un client avec son nom
	 * @param pNom
	 * @return Client
	 */
	public Client findByNom(String pNom); 
	
	/**
	 * Méthode de requête qui permet de récupérer une liste des clients intéréssés par une classe Standard 
	 * @param pIdClasseStandard : id de la classe d'interet
	 * @return liste de clients
	 */
// A VERIF 
	public List<Client> findByListeClassesStandardsInteretIdClasseStandard(Long pIdClasseStandard); 

}// end interface
