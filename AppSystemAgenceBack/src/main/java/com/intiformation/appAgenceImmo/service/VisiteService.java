package com.intiformation.appAgenceImmo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.VisiteRepository;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;
import com.intiformation.appAgenceImmo.modele.Visite;

/**
 * Implémentation concrète de la couche service pour une adresse
 * 
 * @author anais
 *
 */
@Service
public class VisiteService implements IVisiteService {
	
	// déclaration du repository + injection spring
	@Autowired
	private VisiteRepository visiteRepository;

	
	// FIND ALL
	@Override
	public List<Visite> trouverTout() {
		return visiteRepository.findAll();
	}

	// GET BY ID 
	@Override
	public Visite trouverViaId(Long pIdVisite) {
		Optional<Visite> visiteRecup = visiteRepository.findById(pIdVisite);
		return null;
	}

	// GET ONE BY ID 
	@Override
	public Visite trouverUn(Long pIdVisite) {
		return visiteRepository.getOne(pIdVisite);
	}
	
	// ADD
	@Override
	public Visite ajouter(Visite pVisite) {
		return visiteRepository.save(pVisite);
	}
	
	// UPDATE
	@Override
	public Visite modifier(Visite pVisite) {
		return visiteRepository.save(pVisite);
	}

	// DELETE
	@Override
	public void supprimer(Visite pVisite) {
		visiteRepository.delete(pVisite);
	}

	// DELETE BY ID
	@Override
	public void supprimerViaId(Long pIdVisite) {
		visiteRepository.deleteById(pIdVisite);
	}

	// Liste des Visites Par DATE
	@Override
	public List<Visite> trouverParDateVisite(Date pDate) {
		return visiteRepository.findByDateVisite(pDate);
	}

	// Liste des Visites Par Client
	@Override
	public List<Visite> trouverParClient(Client pClient) {
		return visiteRepository.findByClient(pClient);
	}

	// Liste des Visites Par Agent Immobilier
	@Override
	public List<Visite> trouverParAgentImmobilier(AgentImmobilier pAgent) {
		return visiteRepository.findByAgentImmobilier(pAgent);
	}

	// Liste des Visites Par Bien immobilier
	@Override
	public List<Visite> trouverParBienImmobilier(BienImmobilier pBien) {
		return visiteRepository.findByBienImmobilier(pBien);
	}

	// Liste des Visites Par Bien immobilier et Date 
	@Override
	public List<Visite> trouverParBienImmobilierAndDateVisite(BienImmobilier pBien, Date pDate) {
		return visiteRepository.findByBienImmobilierAndDateVisite(pBien, pDate);
	}

	// Liste des Visites Par Agent immobilier et par Date
	@Override
	public List<Visite> trouverParAgentImmobilierAndDateVisite(AgentImmobilier pAgent, Date pDate) {
		return visiteRepository.findByAgentImmobilierAndDateVisite(pAgent, pDate);
	}

	// Liste des Visites Par Agent immobilier et par Bien immobilier
	@Override
	public List<Visite> trouverParAgentImmobilierAndBienImmobilier(AgentImmobilier pAgent, BienImmobilier pBien) {
		return visiteRepository.findByAgentImmobilierAndBienImmobilier(pAgent, pBien);
	}
	
	
}// end classe
