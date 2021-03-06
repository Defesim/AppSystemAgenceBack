package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * Modèle de données pour une visite
 * 
 * @author hannahlevardon
 *
 */
@Entity
@Table(name = "visites")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
				property = "idVisite")
public class Visite implements Serializable {
	
	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visite")
	private Long idVisite;
	
	@Column(name = "date_visite")
	private Date dateVisite; 
	
	
	/*--------------- ASSOCIATIONS ---------------*/

	/**
	 * Association entre visite et client
	 * Many visites to One client
	 */	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="personne_id")
	private Client client;
	 
	
	/**
	 * Association entre visite et agent immobilier
	 * Many visites to One agent immobilier
	 */
	@ManyToOne
	@JoinColumn(name="agent_immobilier_id", referencedColumnName="personne_id")
	private AgentImmobilier agentImmobilier;
	 
	
	/**
	 * Association entre visite et bien immobilier
	 * Many visites to One bien immobilier
	 */
	@ManyToOne
	@JoinColumn(name="bien_immobilier_id", referencedColumnName="id_bien_immobilier")
	private BienImmobilier bienImmobilier; 
	
	/*--------------- CONSTRUCTEURS ---------------*/
	
	/**
	 * Constructeur vide
	 */
	public Visite() {
	}

	/*--------------- GETTER / SETTER ---------------*/
	
	public Long getIdVisite() {
		return idVisite;
	}

	public void setIdVisite(Long idViste) {
		this.idVisite = idViste;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AgentImmobilier getAgentImmobilier() {
		return agentImmobilier;
	}

	public void setAgentImmobilier(AgentImmobilier agentImmobilier) {
		this.agentImmobilier = agentImmobilier;
	}

}//end classe
