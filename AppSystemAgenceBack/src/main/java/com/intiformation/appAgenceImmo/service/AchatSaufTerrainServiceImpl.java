package com.intiformation.appAgenceImmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.AchatSaufTerrainRepository;
import com.intiformation.appAgenceImmo.modele.AchatSaufTerrain;

/**
 * Implémentation concrète de la couche service pour un achat sauf terrain
 * 
 * @author hannahlevardon
 *
 */
@Service
public class AchatSaufTerrainServiceImpl implements IAchatSaufTerrain {

	/* ___________ PROPRIETES __________ */

	/**
	 * Déclaration de la couche DAO
	 */
	@Autowired
	private AchatSaufTerrainRepository achatSaufTerrainRep;

	/**
	 * Setter pour injection du bean Spring
	 * 
	 * @param achatSaufTerrainRep
	 */
	public void setAchatSaufTerrainRep(AchatSaufTerrainRepository achatSaufTerrainRep) {
		this.achatSaufTerrainRep = achatSaufTerrainRep;
	}

	/* ___________ METHODES __________ */
	
	/**
	 * Récupération de la liste de tous les achats
	 */
	@Override
	public List<AchatSaufTerrain> trouverTout() {
		return achatSaufTerrainRep.findAll();
	}

	/**
	 * Récupérer un achat sauf terrain via son id
	 */
	@Override
	public AchatSaufTerrain trouverViaId(Long pId) {
		return achatSaufTerrainRep.findById(pId).get();
	}

	/**
	 * Récupérer une ref via Id
	 */
	@Override
	public AchatSaufTerrain trouverUn(Long pId) {
		return achatSaufTerrainRep.getOne(pId);
	}

	/**
	 * Ajouter dans la database
	 */
	@Override
	public AchatSaufTerrain ajouter(AchatSaufTerrain t) {
		return achatSaufTerrainRep.save(t);
	}

	/**
	 * Modifier dans la databse
	 */
	@Override
	public AchatSaufTerrain modifier(AchatSaufTerrain t) {
		return achatSaufTerrainRep.save(t);
	}

	/**
	 * Supprimer de la databse
	 */
	@Override
	public void supprimer(AchatSaufTerrain t) {
		achatSaufTerrainRep.delete(t);
	}

	/**
	 * Supprimer de la database via Id
	 */
	@Override
	public void supprimerViaId(Long pId) {
		achatSaufTerrainRep.deleteById(pId);
	}

}// end classe
