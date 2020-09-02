package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;
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
 * Equivalent du contrat d'achat ou de location 
 * 
 * @author hannahlevardon
 *
 */

@Entity
@Table(name = "acquisitions")
public class Acquisition implements Serializable{
	
	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acquisition")
	private Long idAcquisition;
	
	// Type : achat ou location  
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
	
	@OneToOne (cascade= CascadeType.ALL, mappedBy="acquisition")
	private AgentImmobilier agentImmobilier; 
	
	
	/**
	 * Association entre acquisition et client
	 * One acquisition to One client
	 */
	@OneToOne (cascade= CascadeType.ALL, mappedBy="acquisition")
	private Client client; 
	
	
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

	public AgentImmobilier getAgentImmobilier() {
		return agentImmobilier;
	}

	public void setAgentImmobilier(AgentImmobilier agentImmobilier) {
		this.agentImmobilier = agentImmobilier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
}//enc classe















