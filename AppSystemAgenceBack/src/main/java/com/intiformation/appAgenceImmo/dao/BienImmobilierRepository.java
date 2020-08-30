package com.intiformation.appAgenceImmo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;

/**
 * 
 * @author hannahlevardon
 *
 */
@RepositoryRestResource // annotation d'un WS Rest
public interface BienImmobilierRepository extends JpaRepository<BienImmobilier, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers à partir d'une classe Standard
	 * @param pClasseStandard
	 * @return liste de biens immobilier
	 */
	public List<BienImmobilier> findByClasseStandard(ClasseStandard classeStandard); 

}//end interface
