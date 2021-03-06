package com.intiformation.appAgenceImmo.service;

import java.util.List;

import com.intiformation.appAgenceImmo.modele.Acquisition;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;

/**
 * Interface de service pour une acquisition
 * Contient des méthodes spécifiques
 * @author hannahlevardon
 *
 */
public interface IAcquisitionService extends IGenericService<Acquisition> {
	
	public List<Acquisition> trouverParIdClient(Long pIdClient);
	
	public List<Acquisition> trouverParIdAgentImmobilier(Long pIdAgent);
	
	public Acquisition trouverParBienImmobilier(Long pIdBien);
	

}//end interface
