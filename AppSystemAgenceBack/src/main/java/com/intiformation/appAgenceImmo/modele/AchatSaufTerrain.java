package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour tout type de bien à acheter sauf les terrains Hérite
 * de la classe AchatToutBien
 * 
 * @author hannahlevardon
 *
 */
@Entity
@Table(name = "achats_sauf_terrain")
public class AchatSaufTerrain extends AchatToutBien implements Serializable{

	/*--------------- PROPRIETES ---------------*/

	@Column(name = "etat_du_bien")
	private String etatDuBien;
	
	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public AchatSaufTerrain() {
		
	}
	/*--------------- GETTER / SETTER ---------------*/
	
	public String getEtatDuBien() {
		return etatDuBien;
	}

	public void setEtatDuBien(String etatDuBien) {
		this.etatDuBien = etatDuBien;
	}
	
	

}// end classe
