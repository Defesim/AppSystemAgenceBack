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
	public AgentImmobilier() {
	}
	
	// ctor ALL PROPS 
	public AgentImmobilier(int id_personne, String nom, String prenom, String email, Adresse adresse, String motDePasse) {
		super(id_personne, nom, prenom, email, adresse);
		this.motDePasse = motDePasse;
	}

	// ctor SANS Adresse 
	public AgentImmobilier(int id_personne, String nom, String prenom, String email, String motDePasse) {
		super(id_personne, nom, prenom, email);
		this.motDePasse = motDePasse;
	}

	// ctor SANS Id et Adresse
	public AgentImmobilier(String nom, String prenom, String email, String motDePasse) {
		super(nom, prenom, email);
		this.motDePasse = motDePasse;
	}
	
	
	
	// ====== METHODES ======
	// ====== Getters / Setters ======

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	

}// end classe AgentImmobilier
