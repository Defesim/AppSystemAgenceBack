package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.AdresseRepository;
import com.intiformation.appAgenceImmo.modele.Adresse;

/**
 * Implémentation concrète de la couche service pour une adresse
 * 
 * @author anais
 *
 */
@Service
public class AdresseService implements IAdresseService {
	
	// déclaration du repository + injection spring
	@Autowired
	private AdresseRepository adresseRepository;
	

	// FIND ALL
	@Override
	public List<Adresse> trouverTout() {
		return adresseRepository.findAll();
	}

	// GET BY ID 
	@Override
	public Adresse trouverViaId(Long pIdAdresse) {
		Optional<Adresse> adresseRecup = adresseRepository.findById(pIdAdresse);
		return adresseRecup.get();
	}

	// GET ONE BY ID 
	@Override
	public Adresse trouverUn(Long pIdAdresse) {
		return adresseRepository.getOne(pIdAdresse);
	}

	// ADD
	@Override
	public Adresse ajouter(Adresse pAdresse) {
		return adresseRepository.save(pAdresse);
	}

	// UPDATE
	@Override
	public Adresse modifier(Adresse pAdresse) {
		return adresseRepository.save(pAdresse);
	}

	// DELETE
	@Override
	public void supprimer(Adresse pAdresse) {
		adresseRepository.delete(pAdresse);
	}

	// DELETE BY ID
	@Override
	public void supprimerViaId(Long pIdAdresse) {
		adresseRepository.deleteById(pIdAdresse);
	}

}// end classe
