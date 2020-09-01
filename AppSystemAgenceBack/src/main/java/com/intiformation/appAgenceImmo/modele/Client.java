package com.intiformation.appAgenceImmo.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.JoinColumn;

/**
 * classe modele pour un client. 
 * classe qui etend Personne
 * @author anais
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="personne_id",
				referencedColumnName="id_personne")
public class Client extends Personne{
	
	// ====== PROPRIETES ======
	
	private int telephonePrive;
	
	// liste des classes standards qui correspondent aux types de biens qui intéressent le client
	@ManyToMany (cascade= CascadeType.ALL, mappedBy="clients")
	private List<ClasseStandard> listeClassesStandardsInteret;

	
	// ====== Ctors ======
	
	public Client() {
	}

	// ctor PROPS de Personne
	public Client(Long id_personne, String nom, String prenom, String email, Adresse adresse) {
		super(id_personne, nom, prenom, email, adresse);
		// TODO Auto-generated constructor stub
	}
	// ctor PROPS de Personne sans ID / Adresse
	public Client(String nom, String prenom, String email) {
		super(nom, prenom, email);
		// TODO Auto-generated constructor stub
	}
	
	// ctor ALL PROPS 
	public Client(Long id_personne, String nom, String prenom, String email, Adresse adresse,
			int telephonePrive, List<ClasseStandard> listeClassesStandardsInteret) {
		super(id_personne, nom, prenom, email, adresse);
		this.telephonePrive = telephonePrive;
		this.listeClassesStandardsInteret = listeClassesStandardsInteret;
	}


	// ctor SANS Id et Adresse
	public Client(String nom, String prenom, String email, int telephonePrive, 
			List<ClasseStandard> listeClassesStandardsInteret) {
		super(nom, prenom, email);
		this.telephonePrive = telephonePrive;
		this.listeClassesStandardsInteret = listeClassesStandardsInteret;
	}
	
	
	
	// ====== METHODES ======
	// ====== Getters / Setters ======
	

	public int getTelephonePrive() {
		return telephonePrive;
	}

	public void setTelephonePrive(int telephonePrive) {
		this.telephonePrive = telephonePrive;
	}

	public List<ClasseStandard> getListeClassesStandardsInteret() {
		return listeClassesStandardsInteret;
	}

	public void setListeClassesStandardsInteret(List<ClasseStandard> listeClassesStandardsInteret) {
		this.listeClassesStandardsInteret = listeClassesStandardsInteret;
	}


}// end classe Client
