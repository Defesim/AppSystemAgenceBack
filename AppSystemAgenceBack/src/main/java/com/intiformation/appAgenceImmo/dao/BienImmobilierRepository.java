package com.intiformation.appAgenceImmo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.Adresse;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
import com.intiformation.appAgenceImmo.modele.ModeOffre;
import com.intiformation.appAgenceImmo.modele.Proprietaire;

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
	public List<BienImmobilier> findByClasseStandard(ClasseStandard pClasseStandard); 
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers à partir du propriétaire
	 * @param pProprietaire
	 * @return liste de biens immobilier
	 */
	public List<BienImmobilier> findByProprietaire(Proprietaire pProprietaire);
	
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers en fonction du mode d'offre (location / achat) 
	 * @param pModeOffre
	 * @return liste de biens immobilier
	 */
	public List<BienImmobilier> findByModesOffre(ModeOffre pModeOffre);
	
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers en fonction de la ville)
	 * @param pAdresse
	 * @return
	 */
	public List<BienImmobilier> findByAdresseVille(Adresse pAdresseVille); 
	
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers en fonction de la ville)
	 * @param pAdresse
	 * @return
	 */
	public List<BienImmobilier> findByDateDeMiseADisposition(Date dateDeDispo); 
	

}//end interface







