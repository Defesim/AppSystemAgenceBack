package com.intiformation.appAgenceImmo.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour une Location
 * Hérite de la classe ModeOffre
 * 
 * @author hannahlevardon
 *
 */
@Entity
@Table(name = "locations")
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
	
	@Column(name = "fourniture")
	private String fourniture; 
	
	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public Location() {
	}
	
	public Location(double cautionLocative, double loyerMensuel, double chargesMensuelles, String typeBail,
			String fourniture) {
		super();
		this.cautionLocative = cautionLocative;
		this.loyerMensuel = loyerMensuel;
		this.chargesMensuelles = chargesMensuelles;
		this.typeBail = typeBail;
		this.fourniture = fourniture;
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

	public String getFourniture() {
		return fourniture;
	}

	public void setFourniture(String fourniture) {
		this.fourniture = fourniture;
	}
	
	
	
	
	
	

}//end class
