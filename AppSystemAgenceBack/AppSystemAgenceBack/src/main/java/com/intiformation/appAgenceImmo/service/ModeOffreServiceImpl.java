package com.intiformation.appAgenceImmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.intiformation.appAgenceImmo.dao.ModeOffreRepository;
import com.intiformation.appAgenceImmo.modele.ModeOffre;

public class ModeOffreServiceImpl implements IModeOffreService {

	/* ___________ PROPRIETES __________ */

	/**
	 * Déclaration de la couche DAO
	 */
	@Autowired
	private ModeOffreRepository modeOffreRep; 
	
	/**
	 * Setter pour injection bean Spring
	 * @param modeOffreRep
	 */
	public void setModeOffreRep(ModeOffreRepository modeOffreRep) {
		this.modeOffreRep = modeOffreRep;
	}

	
	/*___________ METHODES __________*/

	/**
	 * Récépuration de tous le smonde d'offre dans la database
	 */
	@Override
	public List<ModeOffre> trouverTout() {
		// TODO Auto-generated method stub
		return modeOffreRep.findAll();
	}

	/**
	 * Récupération d'un mode d'offre via son id
	 */
	@Override
	public ModeOffre trouverViaId(Long pId) {
		return modeOffreRep.findById(pId).get();
	}

	/**
	 * Récupération d'une référence à un mode d'offre
	 */
	@Override
	public ModeOffre trouverUn(Long pId) {
		return modeOffreRep.getOne(pId);
	}

	/**
	 * Ajouter un mode d'offre à la databse
	 */
	@Override
	public ModeOffre ajouter(ModeOffre t) {
		return modeOffreRep.save(t);
	}

	/**
	 * Modifier un mode d'offre dans la databse
	 */
	@Override
	public ModeOffre modifier(ModeOffre t) {
		return modeOffreRep.save(t);
	}

	/**
	 * Supprimer un mode d'offre dans la database
	 */
	@Override
	public void supprimer(ModeOffre t) {
		modeOffreRep.delete(t);
	}

	/**
	 * Supprimer un mode d'offre via son Id dans la database
	 */
	@Override
	public void supprimerViaId(Long pId) {
		modeOffreRep.deleteById(pId);
	}

}
