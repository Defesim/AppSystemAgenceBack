package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * classe modele pour toutes les personnes.
 * classe de base pour client / agent immobilier et Proprietaire.
 * classe abstraite.
 * 
 * @author anais
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Personne implements Serializable {
	
	// ====== PROPRIETES ======
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private Long id_personne;
	
	@Column(length=30)
	private String nom;
	
	@Column(length=30)
	private String prenom;
	
	@Column(length=50)
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FKadresseID",referencedColumnName="idAdresse")
	private Adresse adresse;

	
	
	// ====== Ctors ======
	public Personne() {
	}

	public Personne(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Personne(Long id_personne, String nom, String prenom, String email) {
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	public Personne(Long id_personne, String nom, String prenom, String email, Adresse adresse) {
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}
	
	
	
	// ====== METHODES ======
	// ====== Getters / Setters ======

	public Long getId_personne() {
		return id_personne;
	}

	public void setId_personne(Long id_personne) {
		this.id_personne = id_personne;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}




}// end classe Personne 
