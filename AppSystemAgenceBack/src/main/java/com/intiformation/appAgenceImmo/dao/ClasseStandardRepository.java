package com.intiformation.appAgenceImmo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.ClasseStandard;

/**
 * Implementation de la couche DAO pour une classe standard
 * implementation d'un ws REST pour la classe standard
 * @author hannahlevardon
 *
 */
@RepositoryRestResource
public interface ClasseStandardRepository extends JpaRepository<ClasseStandard, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer une classe standard à partir de son libellé
	 * @param pLibelle
	 * @return ClasseStandard
	 */
	public ClasseStandard findByLibelle(String pLibelle); 
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de classes standards en fonction d'un prix maximum
	 * @param pPrixMax
	 * @return Liste de ClasseStandard
	 */
	public List<ClasseStandard> findByPrixMaximumLessThan(double pPrixMax);
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de classes standards en fonction de l'usage : commercial ou habitation
	 * @param pUsage
	 * @return Liste de ClasseStandard
	 */
	public List<ClasseStandard> findByUsageDuBien(String pUsage);
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de classes standards en fonction dy type : maison, appartement, terrain...
	 * @param pType
	 * @return Liste de ClasseStandard
	 */
	public List<ClasseStandard> findByTypeDeBien(String pType);
	
	
}//end interface
