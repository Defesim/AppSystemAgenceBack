package com.intiformation.appAgenceImmo.modele;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	private int telephonePrive;
	
	private int telephonePro;
	
	// liste des biens appartenant au proprietaire
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilier> listeDesBiensDuProprio;
	
	// ====== Ctors ======
	public Proprietaire() {
	}

	// ctor ALL PROPS 
	public Proprietaire(Long id_personne, String nom, String prenom, String email, 
						Adresse adresse, int telephonePrive, int telephonePro) {
		super(id_personne, nom, prenom, email, adresse);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
	}

	// ctor SANS Adresse
	public Proprietaire(Long id_personne, String nom, String prenom, String email, int telephonePrive, int telephonePro) {
		super(id_personne, nom, prenom, email);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
	}

	// ctor SANS Id et Adresse
	public Proprietaire(String nom, String prenom, String email, int telephonePrive, int telephonePro) {
		super(nom, prenom, email);
		this.telephonePrive = telephonePrive;
		this.telephonePro = telephonePro;
	}
	
	

	// ====== METHODES ======
	// ====== Getters / Setters ======

	public int getTelephonePrive() {
		return telephonePrive;
	}

	public void setTelephonePrive(int telephonePrive) {
		this.telephonePrive = telephonePrive;
	}

	public int getTelephonePro() {
		return telephonePro;
	}

	public void setTelephonePro(int telephonePro) {
		this.telephonePro = telephonePro;
	}
	


}// end classe Proprietaire
