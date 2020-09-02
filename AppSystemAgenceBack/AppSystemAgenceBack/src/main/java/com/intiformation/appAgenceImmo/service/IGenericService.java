package com.intiformation.appAgenceImmo.service;

import java.util.List;
/**
 * Interface générique pour le service: 
 * Contient toutes les méthodes communes à toute les interfaces de service
 * @author hannahlevardon
 *
 * @param <T>
 */
public interface IGenericService<T> {
	
	public List<T> trouverTout();
	
	public T trouverViaId(Long pId); 
	
	public T trouverUn(Long pId);
	
	public T ajouter(T t);
	
	public T modifier(T t); 
	
	public void supprimer(T t);
	
	public void supprimerViaId(Long pId);
	
	

}//end interface
