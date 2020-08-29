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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * classe modele pour une visite
 * 
 * @author anais
 *
 */
@Entity
public class Visite implements Serializable{
	
	// ====== PROPRIETES ======
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_visite")
	private int id_visite;
	
	@ManyToOne
	@JoinColumn(name = "agentImmobilier", referencedColumnName = "personne_id")
	private AgentImmobilier agentImmobilier;

	@ManyToOne
	@JoinColumn(name = "client", referencedColumnName = "personne_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "bienImmobilier", referencedColumnName = "id_bien_immobilier")
	private BienImmobilier bienImmobilier;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	// ====== Ctors ======
	public Visite() {
	}
	
	public Visite(int id_visite, AgentImmobilier agentImmobilier, Client client, BienImmobilier bienImmobilier,
			Date date) {
		this.id_visite = id_visite;
		this.agentImmobilier = agentImmobilier;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
		this.date = date;
	}
	
	public Visite(AgentImmobilier agentImmobilier, Client client, BienImmobilier bienImmobilier, Date date) {
		this.agentImmobilier = agentImmobilier;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
		this.date = date;
	}
	
	
	
	// ====== METHODES ======
	// ====== Getters / Setters ======
	

	public int getId_visite() {
		return id_visite;
	}

	public void setId_visite(int id_visite) {
		this.id_visite = id_visite;
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

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}// end classe visite 
