package com.intiformation.appAgenceImmo.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour une Location Hérite de la classe ModeOffre
 * 
 * @author hannahlevardon
 *
 */
@Entity
@Table(name = "locations")
@PrimaryKeyJoinColumn(name ="location_id", referencedColumnName = "id_mode_offre")
public class Location extends ModeOffre {

	/*--------------- PROPRIETES ---------------*/

	@Column(name = "caution")
	private double cautionLocative;

	@Column(name = "loyer")
	private double loyerMensuel;

	@Column(name = "charges_mensuelles")
	private double chargesMensuelles;

	@Column(name = "type_bail")
	private String typeBail;

	@Column(name = "meuble")
	private Boolean meuble;

	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public Location() {
	}

	/*--------------- GETTER / SETTER ---------------*/

	public double getCautionLocative() {
		return cautionLocative;
	}

	public void setCautionLocative(double cautionLocative) {
		this.cautionLocative = cautionLocative;
	}

	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	public double getChargesMensuelles() {
		return chargesMensuelles;
	}

	public void setChargesMensuelles(double chargesMensuelles) {
		this.chargesMensuelles = chargesMensuelles;
	}

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	public Boolean getMeuble() {
		return meuble;
	}

	public void setMeuble(Boolean meuble) {
		this.meuble = meuble;
	}

}// end class
