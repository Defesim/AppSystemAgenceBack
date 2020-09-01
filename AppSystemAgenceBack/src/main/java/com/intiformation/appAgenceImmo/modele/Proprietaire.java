package com.intiformation.appAgenceImmo.modele;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * classe modele pour un propriétaire.
 * classe qui étend la classe Personne 
 * @author anais
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="personne_id",
					referencedColumnName="id_personne")
public class Proprietaire extends Personne{
	
	
	// ====== PROPRIETES ======
	
	private String telephonePrive;
	
	private String telephonePro;
	
	// liste des biens appartenant au proprietaire
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilier> listeDesBiensDuProprio;
	
	// ====== Ctors ======
	public Proprietaire() {
	}

	// ctor ALL PROPS 
	public Proprietaire(Long id_personne, String nom, String prenom, String email, 
						Adresse adresse, String telephonePrive, String telephonePro) {
		super(id_personne, nom, prenom, email, adresse);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
	}

	// ctor ALL PROPS SANS ID
	public Proprietaire(String nom, String prenom, String email, 
			Adresse adresse, String telephonePrive, String telephonePro) {
		super(nom, prenom, email, adresse);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
	}
	
	// ctor SANS Adresse
	public Proprietaire(Long id_personne, String nom, String prenom, String email, String telephonePrive, String telephonePro) {
		super(id_personne, nom, prenom, email);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
	}

	// ctor SANS Id et Adresse
	public Proprietaire(String nom, String prenom, String email, String telephonePrive, String telephonePro) {
		super(nom, prenom, email);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
	}
	
	// Toutes Props avec listeDesBiensDuProprio et sans id
	public Proprietaire(String nom, String prenom, String email, Adresse adresse, String telephonePrive, String telephonePro, List<BienImmobilier> listeDesBiensDuProprio) {
		super(nom, prenom, email, adresse);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
		this.listeDesBiensDuProprio = listeDesBiensDuProprio;
	}

	// ====== METHODES ======
	// ====== Getters / Setters ======


	public String getTelephonePrive() {
		return telephonePrive;
	}

	public void setTelephonePrive(String telephonePrive) {
		this.telephonePrive = telephonePrive;
	}

	public String getTelephonePro() {
		return telephonePro;
	}

	public void setTelephonePro(String telephonePro) {
		this.telephonePro = telephonePro;
	}
	


}// end classe Proprietaire
