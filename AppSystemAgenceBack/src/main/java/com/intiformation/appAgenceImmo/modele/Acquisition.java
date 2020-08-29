package com.intiformation.appAgenceImmo.modele;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour une acquisition/location
 * 
 * @author hannahlevardon
 *
 */

@Entity
@Table(name = "acquisitions")
public class Acquisition {
	
	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acquisition")
	private Long idAcquisition;
	
	@Column(name = "type_acquisition")
	private String typeAcquisition;
	
	@Column(name = "date_achat")
	private Date dateAchat; 
	
	@Column(name = "prix_achat")
	private double prixAchat;
	
	/*--------------- ASSOCIATIONS ---------------*/
	
	/**
	 * Association entre acquisition et bien immobilier
	 * One acquisition to One bien immobilier
	 */
	@OneToOne (cascade= CascadeType.ALL, mappedBy="acquisition")
	private BienImmobilier bienImmobilier; 
	
	/**
	 * Association entre acquisition et agent immobilier
	 * One acquisition to One agent immobilier
	 */
	/*
	@OneToOne
	@JoinColumn(name = "agent_immobilier_id", referencedColumnName = "id_agent_immobilier")
	private AgentImobilier agentImmobilier; 
	*/
	
	/**
	 * Association entre acquisition et client
	 * One acquisition to One client
	 */
	/*
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_client")
	private Client client; 
	*/
	
	/**
	 * Association entre un contrat et un acquisition
	 * One contrat to One acquisition
	 */
	@OneToOne
	@JoinColumn(name = "contrat_id", referencedColumnName = "id_contrat")
	private Contrat contrat; 

	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public Acquisition() {
	}
	
	/*--------------- GETTER / SETTER ---------------*/

	public Long getIdAcquisition() {
		return idAcquisition;
	}

	public void setIdAcquisition(Long idAcquisition) {
		this.idAcquisition = idAcquisition;
	}

	public String getTypeAcquisition() {
		return typeAcquisition;
	}

	public void setTypeAcquisition(String typeAcquisition) {
		this.typeAcquisition = typeAcquisition;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}
	
	
}//enc classe















