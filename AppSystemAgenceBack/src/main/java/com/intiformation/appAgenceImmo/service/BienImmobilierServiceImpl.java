package com.intiformation.appAgenceImmo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.BienImmobilierRepository;
import com.intiformation.appAgenceImmo.modele.Adresse;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
import com.intiformation.appAgenceImmo.modele.ModeOffre;
import com.intiformation.appAgenceImmo.modele.Proprietaire;
/**
 * Implémentation concrète de la couche service pour un bien immobilier
 * @author hannahlevardon
 *
 */
@Service
public class BienImmobilierServiceImpl implements IBienImmobillierService {

	/*___________ PROPRIETES __________*/
	
	/**
	 * Déclaration de la couche DAO
	 */
	@Autowired
	private BienImmobilierRepository bienImmobilierRep; 
	
	/**
	 * Setter pour injection du bean Spring
	 * @param bienImmobilierRep
	 */
	public void setBienImmobilierRep(BienImmobilierRepository bienImmobilierRep) {
		this.bienImmobilierRep = bienImmobilierRep;
	}

	/*___________ METHODES __________*/
	
	/**
	 * Récupération de la liste de tous les biens immobiliers
	 */
	@Override
	public List<BienImmobilier> trouverTout() {
		return bienImmobilierRep.findAll();
	}

	/**
	 * Récupération d'un bien immobilier par son id
	 */
	@Override
	public BienImmobilier trouverViaId(Long pId) {	
		Optional<BienImmobilier> bienImmo =  bienImmobilierRep.findById(pId);
		return bienImmo.get();
	}

	/**
	 * Ajout d'un bien immobilier dans la base de données
	 */
	@Override
	public BienImmobilier ajouter(BienImmobilier pBien) {
		return bienImmobilierRep.save(pBien);
	}

	/**
	 * Modification d'un bien immobilier
	 */
	@Override
	public BienImmobilier modifier(BienImmobilier pBien) {
		return bienImmobilierRep.save(pBien);
	}

	/**
	 * Supprimer un bien Immobilier
	 */
	@Override
	public void supprimer(BienImmobilier pBien) {	
		bienImmobilierRep.delete(pBien);
	}

	/**
	 * Supprimer un bien immobilier par son Id
	 */
	@Override
	public void supprimerViaId(Long pId) {
		bienImmobilierRep.deleteById(pId);
	}

	/**
	 * Récupérer une référence à un bien Immobilier
	 */
	@Override
	public BienImmobilier trouverUn(Long pId) {
		return bienImmobilierRep.getOne(pId);
	}

	/**
	 * Récupérer la liste des biens immobilier en fonction d'une classe Standard
	 */
	@Override
	public List<BienImmobilier> trouverParClasseStandard(ClasseStandard pClasseStandard) {
		return bienImmobilierRep.findByClasseStandard(pClasseStandard);
	}

	@Override
	public List<BienImmobilier> trouverParProprietaire(Proprietaire pProprietaire) {
		return bienImmobilierRep.findByProprietaire(pProprietaire);
	}

	@Override
	public List<BienImmobilier> TrouverParModesOffre(ModeOffre pModeOffre) {
		return bienImmobilierRep.findByModesOffre(pModeOffre);
	}

	@Override
	public List<BienImmobilier> TrouverParVille(Adresse pAdresseVille) {
		return bienImmobilierRep.findByAdresseVille(pAdresseVille);
	}

	@Override
	public List<BienImmobilier> trouverParDateDeMiseADisposition(Date dateDeDispo) {
		return bienImmobilierRep.findByDateDeMiseADisposition(dateDeDispo);
	}

}// end classe
