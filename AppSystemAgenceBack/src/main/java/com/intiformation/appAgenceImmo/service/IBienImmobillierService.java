package com.intiformation.appAgenceImmo.service;

import java.util.Date;
import java.util.List;

import com.intiformation.appAgenceImmo.modele.Adresse;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
import com.intiformation.appAgenceImmo.modele.ModeOffre;
import com.intiformation.appAgenceImmo.modele.Proprietaire;

/**
 * Interface de service du bien immobilier
 * Contient des méthodes spécifiques
 * @author hannahlevardon
 *
 */
public interface IBienImmobillierService extends IGenericService<BienImmobilier> {
	
	public List<BienImmobilier> trouverParClasseStandard(Long pClasseStandard);
	
	public List<BienImmobilier> trouverParProprietaire(Long pIdProprietaire);
	
	public List<BienImmobilier> TrouverParModesOffre( Long pIdModeOffre);
	
	public List<BienImmobilier> TrouverParVille(String pAdresseVille); 
	
	public List<BienImmobilier> trouverParDateDeMiseADisposition(Date dateDeDispo); 


}//end interface
