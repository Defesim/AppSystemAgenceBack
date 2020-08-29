package com.intiformation.appAgenceImmo.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * classe modele pour un agent immobilier.
 * classe qui étend la classe Personne 
 * @author anais
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="personne_id",
					referencedColumnName="id_personne")
public class AgentImmobilier extends Personne {
	
	// ====== PROPRIETES ======
	
	@Column(length=200)
	private String motDePasse;
	
	
	
	
	
	
	// ====== Ctors ======
	// ====== METHODES ======
	// ====== Getters / Setters ======


}// end classe AgentImmobilier
