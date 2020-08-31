package com.intiformation.appAgenceImmo.service;

import java.util.Date;
import java.util.List;

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;
import com.intiformation.appAgenceImmo.modele.Visite;

/**
 * Interface de la couche service pour visite
 * 
 * @author anais
 *
 */
public interface IVisiteService extends IGenericService<Visite> {
	
	public List<Visite> trouverParDateVisite(Date pDate); 
	
	public List<Visite> trouverParClient(Client pClient); 
	
	public List<Visite> trouverParAgentImmobilier(AgentImmobilier pAgent);
	
	public List<Visite> trouverParBienImmobilier(BienImmobilier pBien);
	
	public List<Visite> trouverParBienImmobilierAndDateVisite(BienImmobilier pBien, Date pDate);

	public List<Visite> trouverParAgentImmobilierAndDateVisite(AgentImmobilier pAgent, Date pDate);
	
	public List<Visite> trouverParAgentImmobilierAndBienImmobilier(AgentImmobilier pAgent, BienImmobilier pBien);

	
}// end interface
