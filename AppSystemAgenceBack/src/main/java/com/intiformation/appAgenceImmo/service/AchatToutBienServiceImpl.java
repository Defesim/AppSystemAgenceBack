package com.intiformation.appAgenceImmo.service;

import java.util.List;

import com.intiformation.appAgenceImmo.dao.AchatToutBienRepository;
import com.intiformation.appAgenceImmo.modele.AchatToutBien;

public class AchatToutBienServiceImpl implements IAchatToutBIen {

	/* ___________ PROPRIETES __________ */

	/**
	 * Déclaration de la couche DAO
	 */
	private AchatToutBienRepository achatRep;

	/**
	 * Setter pour injection du bean Spring
	 * 
	 * @param achatRep
	 */
	public void setAchatRep(AchatToutBienRepository achatRep) {
		this.achatRep = achatRep;
	}

	/* ___________ METHODES __________ */

	/**
	 * Récupération de la liste des Achat pour tout bien dans la database
	 */
	@Override
	public List<AchatToutBien> trouverTout() {
		// TODO Auto-generated method stub
		return achatRep.findAll();
	}

	/**
	 * Trouver un achat via son Id dans la database
	 */
	@Override
	public AchatToutBien trouverViaId(Long pId) {
		return achatRep.findById(pId).get();
	}

	/**
	 * Trouver une référence à un achat
	 */
	@Override
	public AchatToutBien trouverUn(Long pId) {
		return achatRep.getOne(pId);
	}

	/**
	 * Ajouter un achat dans la database
	 */
	@Override
	public AchatToutBien ajouter(AchatToutBien pAchat) {
		return achatRep.save(pAchat);
	}

	/**
	 * Modifier un achat dans la database
	 */
	@Override
	public AchatToutBien modifier(AchatToutBien pAchat) {
		return achatRep.save(pAchat);
	}

	/**
	 * Supprimer un achat dans la database
	 */
	@Override
	public void supprimer(AchatToutBien pAchat) {
		achatRep.delete(pAchat);
	}

	/**
	 * Supprimer un achat via son Id dans la database
	 */
	@Override
	public void supprimerViaId(Long pId) {
		achatRep.deleteById(pId);
	}

}// end classe
