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
 * classe modele pour une acquisition
 * 
 * @author anais 
 *
 */
@Entity
public class Acquisition implements Serializable {
	
	// ====== PROPRIETES ======
	// ====== PROPRIETES ======
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id_acquisition")
		private int id_acquisition;
		
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
		private Date dateAcquisition;
		
		private double prixAcquisition;

		// ====== Ctors ======
		public Acquisition() {
		}
		
		public Acquisition(AgentImmobilier agentImmobilier, Client client,
				BienImmobilier bienImmobilier, Date dateAcquisition, double prixAcquisition) {
			this.agentImmobilier = agentImmobilier;
			this.client = client;
			this.bienImmobilier = bienImmobilier;
			this.dateAcquisition = dateAcquisition;
			this.prixAcquisition = prixAcquisition;
		}
		
		public Acquisition(int id_acquisition, AgentImmobilier agentImmobilier, Client client,
				BienImmobilier bienImmobilier, Date dateAcquisition, double prixAcquisition) {
			this.id_acquisition = id_acquisition;
			this.agentImmobilier = agentImmobilier;
			this.client = client;
			this.bienImmobilier = bienImmobilier;
			this.dateAcquisition = dateAcquisition;
			this.prixAcquisition = prixAcquisition;
		}


		
		// ====== METHODES ======
		// ====== Getters / Setters ======
		
	

		public int getId_acquisition() {
			return id_acquisition;
		}

		public void setId_acquisition(int id_acquisition) {
			this.id_acquisition = id_acquisition;
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

		public Date getDateAcquisition() {
			return dateAcquisition;
		}

		public void setDateAcquisition(Date dateAcquisition) {
			this.dateAcquisition = dateAcquisition;
		}

		public double getPrixAcquisition() {
			return prixAcquisition;
		}

		public void setPrixAcquisition(double prixAcquisition) {
			this.prixAcquisition = prixAcquisition;
		}
		
		


}// end classe Acquisition
