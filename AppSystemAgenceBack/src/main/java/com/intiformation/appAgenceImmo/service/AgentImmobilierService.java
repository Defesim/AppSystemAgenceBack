package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.AgentImmobilierRepository;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;

/**
 * Implémentation concrète de la couche service pour un agent immobilier
 * 
 * @author anais
 *
 */
@Service
public class AgentImmobilierService implements IAgentImmobilierService {
	
	// déclaration du repository + injection spring
	@Autowired
	private AgentImmobilierRepository agentImmobilierRepository;

	// FIND ALL
	@Override
	public List<AgentImmobilier> trouverTout() {
		return agentImmobilierRepository.findAll();
	}

	// GET BY ID
	@Override
	public AgentImmobilier trouverViaId(Long pIdAgentImmobilier) {
		Optional<AgentImmobilier> agentImmoRecup = agentImmobilierRepository.findById(pIdAgentImmobilier);
		return agentImmoRecup.get();
	}

	// GET ONE BY ID 
	@Override
	public AgentImmobilier trouverUn(Long pIdAgentImmobilier) {
		return agentImmobilierRepository.getOne(pIdAgentImmobilier);
	}

	// ADD
	@Override
	public AgentImmobilier ajouter(AgentImmobilier pAgentImmobilier) {
		return agentImmobilierRepository.save(pAgentImmobilier);
	}

	// UPDATE
	@Override
	public AgentImmobilier modifier(AgentImmobilier pAgentImmobilier) {
		return agentImmobilierRepository.save(pAgentImmobilier);
	}

	// DELETE
	@Override
	public void supprimer(AgentImmobilier pAgentImmobilier) {
		agentImmobilierRepository.delete(pAgentImmobilier);
	}

	// DELETE BY ID
	@Override
	public void supprimerViaId(Long pIdAgentImmobilier) {
		agentImmobilierRepository.deleteById(pIdAgentImmobilier);
	}

}// end classe
