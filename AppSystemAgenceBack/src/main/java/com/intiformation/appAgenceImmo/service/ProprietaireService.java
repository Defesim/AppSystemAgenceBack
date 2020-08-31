package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.ProprietaireRepository;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Proprietaire;

/**
 * Implémentation concrète de la couche service pour un proprietaire
 * 
 * @author anais
 *
 */
@Service
public class ProprietaireService implements IProprietaireService {
	
	// déclaration du repository + injection spring
	@Autowired
	private ProprietaireRepository proprietaireRepository;

	// FIND ALL
	@Override
	public List<Proprietaire> trouverTout() {
		return proprietaireRepository.findAll();
	}

	// GET BY ID 
	@Override
	public Proprietaire trouverViaId(Long pIdProprietaire) {
		Optional<Proprietaire> proprietaireRecup = proprietaireRepository.findById(pIdProprietaire);
		return null;
	}

	// GET ONE BY ID 
	@Override
	public Proprietaire trouverUn(Long pIdProprietaire) {
		return proprietaireRepository.getOne(pIdProprietaire);
	}

	// ADD
	@Override
	public Proprietaire ajouter(Proprietaire pProprietaire) {
		return proprietaireRepository.save(pProprietaire);
	}

	// UPDATE
	@Override
	public Proprietaire modifier(Proprietaire pProprietaire) {
		return proprietaireRepository.save(pProprietaire);
	}

	// DELETE
	@Override
	public void supprimer(Proprietaire pProprietaire) {
		proprietaireRepository.delete(pProprietaire);
	}

	// DELETE BY ID
	@Override
	public void supprimerViaId(Long pIdProprietaire) {
		proprietaireRepository.deleteById(pIdProprietaire);
		
	}

	// récup du proprietaire d'un bien immobilier 
	@Override
	public Proprietaire TrouverParLeBienDuProprio(BienImmobilier pBien) {
		return proprietaireRepository.findByListeDesBiensDuProprio(pBien);
	}
	

}// end classe
