package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.PersonneRepository;
import com.intiformation.appAgenceImmo.modele.Personne;

/**
 * Implémentation concrète de la couche service pour une Personne
 * 
 * @author anais
 *
 */
@Service
public class PersonneService implements IPersonneService{
	
	// déclaration du repository + injection spring
	@Autowired
	private PersonneRepository personneRepository;

	// FIND ALL
	@Override
	public List<Personne> trouverTout() {
		return personneRepository.findAll();
	}

	// GET BY ID 
	@Override
	public Personne trouverViaId(Long pIdPersonne) {
		Optional<Personne> personneRecup = personneRepository.findById(pIdPersonne);
		return personneRecup.get();
	}

	// GET ONE BY ID 
	@Override
	public Personne trouverUn(Long pIdPersonne) {
		return personneRepository.getOne(pIdPersonne);
	}

	// ADD
	@Override
	public Personne ajouter(Personne pPersonne) {
		return personneRepository.save(pPersonne);
	}

	// UPDATE
	@Override
	public Personne modifier(Personne pPersonne) {
		return personneRepository.save(pPersonne);
	}

	// DELETE
	@Override
	public void supprimer(Personne pPersonne) {
		personneRepository.delete(pPersonne);
	}

	// DELETE BY ID
	@Override
	public void supprimerViaId(Long pIdPersonne) {
		personneRepository.deleteById(pIdPersonne);
	}

	// trouver une personne via son nom
	@Override
	public Personne findByNom(String pNom) {
		return personneRepository.findByNom(pNom);
	}

}// end classe 
