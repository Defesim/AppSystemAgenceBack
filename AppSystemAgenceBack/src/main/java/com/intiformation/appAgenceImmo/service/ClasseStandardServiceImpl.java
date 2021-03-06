package com.intiformation.appAgenceImmo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.dao.ClasseStandardRepository;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
@Service
public class ClasseStandardServiceImpl implements IClasseStandardService {

	
	/*___________ PROPRIETES __________*/
	
	/**
	 * Déclaration de la couche DAO
	 */
	@Autowired
	private ClasseStandardRepository classeStandarRep;
	
	/**
	 * Setter pour injection du bean Spring
	 * @param classeStandarRep
	 */
	public void setClasseStandarRep(ClasseStandardRepository classeStandarRep) {
		this.classeStandarRep = classeStandarRep;
	}//end setter

	/*___________ METHODES __________*/
	
	
	/**
	 * Récupération de la liste de toutes les classes standards
	 */
	@Override
	public List<ClasseStandard> trouverTout() {
		return classeStandarRep.findAll();
	}

	/**
	 * Récupération d'une classe standard par son id
	 */
	@Override
	public ClasseStandard trouverViaId(Long pId) {
		Optional<ClasseStandard> classeStandard = classeStandarRep.findById(pId);
		return classeStandard.get();
	}

	/**
	 * Récupérer une référence à classe standard
	 */
	@Override
	public ClasseStandard trouverUn(Long pId) {
		return classeStandarRep.getOne(pId);
	}
	
	/**
	 * Ajouter une classe standard
	 */
	@Override
	public ClasseStandard ajouter(ClasseStandard pClasse) {
		return classeStandarRep.save(pClasse);
	}

	/**
	 * Modifier une classe standard
	 */
	@Override
	public ClasseStandard modifier(ClasseStandard pClasse) {
		return classeStandarRep.save(pClasse);
	}

	/**
	 * Supprimer classe standard
	 */
	@Override
	public void supprimer(ClasseStandard pClasse) {
		classeStandarRep.delete(pClasse);
	}

	/**
	 * Supprimer un classe standard par son id
	 */
	@Override
	public void supprimerViaId(Long pId) {
		classeStandarRep.deleteById(pId);
	}

	/**
	 * Récupérer une classe standard via son libellé
	 */
	@Override
	public ClasseStandard trouverParLibelle(String pLibelle) {
		return classeStandarRep.findByLibelle(pLibelle);
	}

	/**
	 * Récupérer une liste de classes standards par prix maximum
	 */
	@Override
	public List<ClasseStandard> trouverParPrixMaximum(double pPrixMax) {	
		return classeStandarRep.findByPrixMaximum(pPrixMax);
	}

	/**
	 * Récupérer une liste de classes standards par usage du bien
	 */
	@Override
	public List<ClasseStandard> trouverParUsageDuBien(String pUsage) {		
		return classeStandarRep.findByUsageDuBien(pUsage);
	}

	/**
	 * Récupérer une liste de classes standards par type de bien 
	 */
	@Override
	public List<ClasseStandard> trouverParTypeDeBien(String pType) {
		return classeStandarRep.findByTypeDeBien(pType);
	}

}//end class









