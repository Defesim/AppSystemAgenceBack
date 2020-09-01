package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.AcquisitionRepository;
import com.intiformation.appAgenceImmo.modele.Acquisition;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;
/**
 * Implémentation concrète de la couche service pour une acquisition/contrat
 * @author hannahlevardon
 *
 */
@Service
public class AcquisitionServiceImpl implements IAcquisitionService {


	/*___________ PROPRIETES __________*/
	
	/**
	 * Déclaration de la couche DAO
	 */
	@Autowired
	private AcquisitionRepository acquisitionRep;
	
	/**
	 * Setter pour injection bean Spring
	 * @param acquisitionRep
	 */
	public void setAcquisitionRep(AcquisitionRepository acquisitionRep) {
		this.acquisitionRep = acquisitionRep;
	}

	/*___________ METHODES __________*/
	/**
	 * Récupération de la liste de toutes les acquisitions
	 */
	@Override
	public List<Acquisition> trouverTout() {
		return acquisitionRep.findAll();
	}
	
	/**
	 * Récupération d'une acquisition par son id
	 */
	@Override
	public Acquisition trouverViaId(Long pId) {
		Optional<Acquisition> acquistion = acquisitionRep.findById(pId);
		return acquistion.get();
	}

	/**
	 * Récupérer une référence à une acquisition
	 */
	@Override
	public Acquisition trouverUn(Long pId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Ajouter une acquisition dans la database
	 */
	@Override
	public Acquisition ajouter(Acquisition pAcquisition) {
		return acquisitionRep.save(pAcquisition);
	}

	/**
	 * Modifier une acquisition dans la database
	 */
	@Override
	public Acquisition modifier(Acquisition pAcquisition) {
		return acquisitionRep.save(pAcquisition);
	}

	/**
	 * Supprimer un acquistion dans la database
	 */
	@Override
	public void supprimer(Acquisition pAcquisition ) {
		acquisitionRep.delete(pAcquisition);
	}


	/**
	 * Supprimer un acquistion dans la database via son id
	 */
	@Override
	public void supprimerViaId(Long pId) {
		acquisitionRep.deleteById(pId);	
	}

	/**
	 * Récupération de la liste des acquisitions d'un client
	 */
	@Override
	public List<Acquisition> trouverParIdClient(Long pIdClient) {
		return acquisitionRep.findByClientId(pIdClient);
	}

	/**
	 * Récupération de la liste des acquisitions gérées par un agent immobilier
	 */
	@Override
	public List<Acquisition> trouverParIdAgentImmobilier(Long pIdAgent) {
		return acquisitionRep.findByIdAgentImmobilier(pIdAgent);
	}

	/**
	 * Récupération de acquisitions liée à un bien immobilier
	 */
	@Override
	public Acquisition trouverParBienImmobilier(Long pIdBien) {
		return acquisitionRep.findByBienImmobilierIdBienImmobilier(pIdBien);
	}

	
}//end classe
