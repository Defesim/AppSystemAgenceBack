package com.intiformation.appAgenceImmo.modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour une visite
 * 
 * @author hannahlevardon
 *
 */
@Entity
@Table(name = "visites")
public class Visite {
	
	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visite")
	private Long idViste;
	
	@Column(name = "date_visite")
	private Date dateVisite; 
	
	
	/*--------------- ASSOCIATIONS ---------------*/

	/**
	 * Association entre visite en client
	 * Many visites to One client
	 */
	/*
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client;
	 */
	
	/**
	 * Association entre visite en agent immobilier
	 * Many visites to One agent immobilier
	 */
	/*
	@ManyToOne
	@JoinColumn(name="agent_immobilier_id", referencedColumnName="id_agent_immobilier")
	private AgentImmobilier agentImmobilier;
	 */
	
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
	
	public Long getIdViste() {
		return idViste;
	}

	public void setIdViste(Long idViste) {
		this.idViste = idViste;
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

}//end classe
