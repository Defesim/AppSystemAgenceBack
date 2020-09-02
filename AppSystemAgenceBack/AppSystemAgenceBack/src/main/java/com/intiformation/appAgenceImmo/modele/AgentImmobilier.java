package com.intiformation.appAgenceImmo.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * classe modele pour un agent immobilier.
 * classe qui étend la classe Personne 
 * @author anais
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="personne_id",
					referencedColumnName="id_personne")
public class AgentImmobilier extends Personne {
	
	// ====== PROPRIETES ======
	
	@Column(length=200)
	private String motDePasse;
	
	/**
	 * Association entre agent immobilier et visite 
	 * One Agent to Many visites
	 */	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agentImmobilier")
	private List<Visite> listeVisitesDunAgentImmo;
	
	/**
	 * Association entre acquisition et agent immobilier
	 * One acquisition to One agent immobilier
	 */
	@OneToOne
	@JoinColumn(name = "acquisition_id", referencedColumnName = "id_acquisition")
	private Acquisition acquisition;
	
	
	// ====== Ctors ======
	public AgentImmobilier() {
	}
	
	// ctor ALL PROPS 
	public AgentImmobilier(Long id_personne, String nom, String prenom, String email, Adresse adresse, String motDePasse) {
		super(id_personne, nom, prenom, email, adresse);
		this.motDePasse = motDePasse;
	}

	// ctor SANS Adresse 
	public AgentImmobilier(Long id_personne, String nom, String prenom, String email, String motDePasse) {
		super(id_personne, nom, prenom, email);
		this.motDePasse = motDePasse;
	}

	// ctor SANS Id et Adresse
	public AgentImmobilier(String nom, String prenom, String email, String motDePasse) {
		super(nom, prenom, email);
		this.motDePasse = motDePasse;
	}
	
	
	
	// ====== METHODES ======
	// ====== Getters / Setters ======

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Visite> getListeVisitesDunAgentImmo() {
		return listeVisitesDunAgentImmo;
	}

	public void setListeVisitesDunAgentImmo(List<Visite> listeVisitesDunAgentImmo) {
		this.listeVisitesDunAgentImmo = listeVisitesDunAgentImmo;
	}

	public Acquisition getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(Acquisition acquisition) {
		this.acquisition = acquisition;
	}
	
	

}// end classe AgentImmobilier
