package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Long id;

	// l'url de l'image
	private String image;
	
	@Lob
	@JsonIgnore
	private byte[] photo;
	
	// lien de l'image avec un bien immobilier : Many images To 1 bien immobilier
	@ManyToOne
	@JoinColumn(name="bien_immobilier_id", referencedColumnName="id_bien_immobilier")
	private BienImmobilier bienImmobilier ;

	
	// ====== Ctors ======
	public Image() {
	}	
	
	// ctors All Props 
	public Image(Long id, String image, BienImmobilier bienImmobilier) {
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	
	
}// end image 
