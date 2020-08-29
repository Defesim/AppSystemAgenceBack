package com.intiformation.appAgenceImmo.modele;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour un Contrat
 * 
 * @author hannahlevardon
 *
 */

@Entity
@Table(name = "contrats")
public class Contrat {
	
	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private Long idContrat;
	
	/*--------------- ASSOCIATIONS ---------------*/
	/**
	 * Association entre un contrat et un acquisition
	 * One contrat to One acquisition
	 */
	@OneToOne(cascade= CascadeType.ALL, mappedBy="contrat")
	private Acquisition acquisition; 
	
	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public Contrat() {
	}

	/*--------------- GETTER / SETTER ---------------*/
	public Long getIdAContrat() {
		return idContrat;
	}

	public void setIdAContrat(Long idAContrat) {
		this.idContrat = idAContrat;
	}

	public Acquisition getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(Acquisition acquisition) {
		this.acquisition = acquisition;
	}
	
	

}//end classe
