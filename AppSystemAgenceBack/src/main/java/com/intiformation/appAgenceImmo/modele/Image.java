package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * classe modele pour les photos/images utilisées dans la description des biens immobiliers 
 * 
 * @author anais
 *
 */
@Entity
public class Image implements Serializable{

	// ====== PROPRIETES ======
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_image")
	private int id;

	// l'url de l'image
	private String image;
	
	// lien de l'image avec un bien immobilier : Many images To 1 bien immobilier
	@ManyToOne
	@JoinColumn(name="bien_immobilier_id", referencedColumnName="id_bien_immobilier")
	private BienImmobilier bienImmobilier ;

	
	// ====== Ctors ======
	public Image() {
	}	
	
	// ctors All Props 
	public Image(int id, String image, BienImmobilier bienImmobilier) {
		this.id = id;
		this.image = image;
		this.bienImmobilier = bienImmobilier;
	}
	
	// ctors SANS Id
	public Image(String image, BienImmobilier bienImmobilier) {
		this.image = image;
		this.bienImmobilier = bienImmobilier;
	}
	
	

	// ====== METHODES ======
	// ====== Getters / Setters ======
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}
	
	
	
	
}// end image 
