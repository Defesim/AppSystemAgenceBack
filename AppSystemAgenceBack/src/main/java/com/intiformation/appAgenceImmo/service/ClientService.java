package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.ClientRepository;
import com.intiformation.appAgenceImmo.modele.Client;

/**
 * Implémentation concrète de la couche service pour un client
 * 
 * @author anais
 *
 */
@Service
public class ClientService implements IClientService{
	
	// déclaration du repository + injection spring
	@Autowired
	private ClientRepository clientRepository;
	
	// FIND ALL
	@Override
	public List<Client> trouverTout() {
		return clientRepository.findAll();
	}

	// GET BY ID 
	@Override
	public Client trouverViaId(Long pIdClient) {
		Optional<Client> clientRecup = clientRepository.findById(pIdClient);
		return clientRecup.get();
	}

	// GET ONE BY ID 
	@Override
	public Client trouverUn(Long pIdClient) {
		return clientRepository.getOne(pIdClient);
	}

	// ADD
	@Override
	public Client ajouter(Client pClient) {
		return clientRepository.save(pClient);
	}

	// UPDATE
	@Override
	public Client modifier(Client pClient) {
		return clientRepository.save(pClient);
	}

	// DELETE
	@Override
	public void supprimer(Client pClient) {
		clientRepository.delete(pClient);
	}

	// DELETE BY ID
	@Override
	public void supprimerViaId(Long pIdClient) {
		clientRepository.deleteById(pIdClient);
	}

	// trouver un client via son nom
	@Override
	public Client findByNom(String pNom) {
		return clientRepository.findByNom(pNom);
	}

	// permet de récupérer la liste des clients intéréssés par une classe Standard 
	@Override
	public List<Client> findByListeClassesStandardsInteretIdClasseStandard(Long pIdClasseStandard) {
		return clientRepository.findByListeClassesStandardsInteretIdClasseStandard(pIdClasseStandard);
	}

}// end classe
