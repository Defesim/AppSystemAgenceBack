package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * classe modele pour les adresses
 * @author anais
 *
 */
@Entity
public class Adresse implements Serializable {
	
	// ====== PROPRIETES ======
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdresse;
	
	@Column(length=50)
	private String rue;
	
	@Column(length=10)
	private String codePostal;
	
	@Column(length=30)
	private String ville;
	
	
	// ====== Ctors ======

	public Adresse() {
	}
	
	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse(int idAdresse, String rue, String codePostal, String ville) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	// ====== METHODES ======
	// ====== Getters / Setters ======

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


}// end classe Adresse

