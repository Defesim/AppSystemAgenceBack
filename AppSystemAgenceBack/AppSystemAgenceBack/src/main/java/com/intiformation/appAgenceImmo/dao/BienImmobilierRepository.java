package com.intiformation.appAgenceImmo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.intiformation.appAgenceImmo.modele.Adresse;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
import com.intiformation.appAgenceImmo.modele.ModeOffre;
import com.intiformation.appAgenceImmo.modele.Proprietaire;

/**
 * Implementation de la couche DAO pour un bien immobilier
 * implementation d'un ws REST pour le bien immobilier 
 * @author hannahlevardon
 *
 */

//@RepositoryRestResource // annotation d'un WS Rest
@Repository
public interface BienImmobilierRepository extends JpaRepository<BienImmobilier, Long> {
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers à partir d'une classe Standard
	 * @param pClasseStandard
	 * @return liste de biens immobilier
	 */
	public List<BienImmobilier> findByClasseStandardIdClasseStandard(Long pIdClasseStandard); 
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers à partir du propriétaire
	 * @param pProprietaire
	 * @return liste de biens immobilier
	 */
	@Query("Select b From BienImmobilier b Where b.proprietaire.id_personne = :pIdProprietaire")
	public List<BienImmobilier> findByIdProprietaire(@Param("pIdProprietaire")Long pIdClient);
	
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers en fonction du mode d'offre (location / achat) 
	 * @param pModeOffre
	 * @return liste de biens immobilier
	 */
	public List<BienImmobilier> findByModesOffreIdModeOffre(Long pIdModeOffre);
	
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers en fonction de la ville)
	 * @param pAdresse
	 * @return
	 */
	public List<BienImmobilier> findByAdresseVille(String pVille); 
	
	
	/**
	 * Méthode de requête qui permet de récupérer une liste de biens immobiliers en fonction de la ville)
	 * @param pAdresse
	 * @return
	 */
	public List<BienImmobilier> findByDateDeMiseADisposition(Date dateDeDispo); 
	

}//end interface







