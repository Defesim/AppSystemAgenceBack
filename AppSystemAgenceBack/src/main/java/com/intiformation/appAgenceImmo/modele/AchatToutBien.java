package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour tout type de bien à acheter
 * Hérite de la classe ModeOffre
 * 
 * @author hannahlevardon
 *
 */
@Entity
@Table(name = "achats_tous_biens")
@PrimaryKeyJoinColumn(name="achat_id",
referencedColumnName="id_mode_offre")
//@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class AchatToutBien extends ModeOffre{
	
	/*--------------- PROPRIETES ---------------*/
	
	@Column(name = "prix_achat_demande")
	private double prixAchatDemande;
	
	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public AchatToutBien() {
	}

	/*--------------- GETTER / SETTER ---------------*/
	
	public double getPrixAchatDemande() {
		return prixAchatDemande;
	}

	public void setPrixAchatDemande(double prixAchatDemande) {
		this.prixAchatDemande = prixAchatDemande;
	}
	
	
	

	
}//enc classe
