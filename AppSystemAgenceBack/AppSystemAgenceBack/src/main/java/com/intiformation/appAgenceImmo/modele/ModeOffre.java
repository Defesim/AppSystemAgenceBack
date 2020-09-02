package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour un mode d'offre
 * 
 * @author hannahlevardon
 *
 */

@Entity
@Table(name ="modes_offres")
@Inheritance(strategy= InheritanceType.JOINED)
public class ModeOffre implements Serializable {
	
	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mode_offre")
	private Long idModeOffre;
	
	// type de l'offre: location ou achat
	@Column(name = "type_mode_offre")
	private String typeModeOffre; 
	
	
	/*--------------- ASSOCIATIONS ---------------*/
	
	/**
	 * Association entre mode d'offre et classe standard
	 * One mode d'offre pour many classes standards
	 */
	@OneToOne(cascade=CascadeType.ALL, mappedBy="modesOffre")
	private BienImmobilier bienImmobilier;
	
	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public ModeOffre() {
	}//end constructeur
	
	
	/*--------------- GETTER / SETTER ---------------*/

	public Long getIdModeOffre() {
		return idModeOffre;
	}

	public void setIdModeOffre(Long idModeOffre) {
		this.idModeOffre = idModeOffre;
	}

	public String getTypeModeOffre() {
		return typeModeOffre;
	}

	public void setTypeModeOffre(String typeModeOffre) {
		this.typeModeOffre = typeModeOffre;
	}


	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}


	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}


}//end class
