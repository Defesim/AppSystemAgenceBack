package com.intiformation.appAgenceImmo.service;

import java.util.List;

import com.intiformation.appAgenceImmo.modele.ClasseStandard;

/**
 * Interface de la couche service pour une classe Standard
 * Contient des méthodes spécifiques
 * @author hannahlevardon
 *
 */
public interface IClasseStandardService extends IGenericService<ClasseStandard> {
	
	public ClasseStandard trouverParLibelle(String pLibelle);
	
	public List<ClasseStandard> trouverParPrixMaximum(double pPrixMax);
	
	public List<ClasseStandard> trouverParUsageDuBien(String pUsage);
	
	public List<ClasseStandard> trouverParTypeDeBien(String pType);

}//end interface
