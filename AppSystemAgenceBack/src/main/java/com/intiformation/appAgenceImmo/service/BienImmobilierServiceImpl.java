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
	
	@Override
	public List<BienImmobilier> trouverTout() {
		return bienImmobilierRep.findAll();
	}

	@Override
	public BienImmobilier trouverViaId(Long pId) {	
		Optional<BienImmobilier> bienImmo =  bienImmobilierRep.findById(pId);
		return bienImmo.get();
	}

	@Override
	public BienImmobilier ajouter(BienImmobilier pBien) {
		return bienImmobilierRep.save(pBien);
	}

	@Override
	public BienImmobilier modifier(BienImmobilier pBien) {
		return bienImmobilierRep.save(pBien);
	}

	@Override
	public void supprimer(BienImmobilier pBien) {	
		bienImmobilierRep.delete(pBien);
	}

	@Override
	public void supprimerViaId(Long pId) {
		bienImmobilierRep.deleteById(pId);
	}

	@Override
	public BienImmobilier trouverUn(Long pId) {
		return bienImmobilierRep.getOne(pId);
	}

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
