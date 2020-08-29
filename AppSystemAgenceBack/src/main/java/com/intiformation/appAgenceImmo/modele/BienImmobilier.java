package com.intiformation.appAgenceImmo.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Modèle de données pour un bien immobilier
 * 
 * @author hannahlevardon
 *
 */
@Entity
@Table(name = "biens_immobilliers")
public class BienImmobilier {

	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bien_immobilier")
	private Long idBienImmobilier;

	@Column(name = "statut")
	private String statut;

	@Column(name = "date_soumission")
	private Date dateDeSoumission;

	@Column(name = "date_mise_a_disposition")
	private Date dateDeMiseADisposition;

	@Column(name = "revenu_cadastral")
	private double revenuCadastral;

	/*--------------- ASSOCIATIONS ---------------*/

	/**
	 * Association entre bien immobilier et adresse 
	 * One bien Immobilier to one adresse
	 */
	@OneToOne
	@JoinColumn(name="adresse_id", referencedColumnName="id_adresse")
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "classe_standard_id", referencedColumnName = "id_classe_standard")
	private ClasseStandard classeStandard;

	/**
	 * Association entre bien immobilier et visite 
	 * One bien Immobilier to Many visites
	 * 
	 * Permet de faire le lien entre le bien immobilier, l'agent qui gère la visite
	 * et le client qui visite
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bienImmobilier")
	private List<Visite> visites;

	/**
	 * Association entre acquisition et bien immobilier 
	 * One acquisition to One bien immobilier
	 * 
	 * Permet de faire le lien entre l'agent responsable du contrat d'acquisition,
	 * le client acheteur/locataire et le bien immobilier acquis/loué
	 */
	@OneToOne
	@JoinColumn(name = "acquisition_id", referencedColumnName = "id_acquisition")
	private Acquisition acquisition;
	
	/**
	 * Association entre bien immobilier et mode d'offre 
	 * Many classes standards pour one mode d'offre
	 */
	@OneToOne
	@JoinColumn(name="mode_offre_id", referencedColumnName="id_mode_offre")
	private ModeOffre modesOffre;

	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public BienImmobilier() {
	}// end constructeur

	/*--------------- GETTER / SETTER ---------------*/
	public Long getIdBienImmobilier() {
		return idBienImmobilier;
	}

	public void setIdBienImmobilier(Long idBienImmobilier) {
		this.idBienImmobilier = idBienImmobilier;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateDeSoumission() {
		return dateDeSoumission;
	}

	public void setDateDeSoumission(Date dateDeSoumission) {
		this.dateDeSoumission = dateDeSoumission;
	}

	public Date getDateDeMiseADisposition() {
		return dateDeMiseADisposition;
	}

	public void setDateDeMiseADisposition(Date dateDeMiseADisposition) {
		this.dateDeMiseADisposition = dateDeMiseADisposition;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	public Acquisition getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(Acquisition acquisition) {
		this.acquisition = acquisition;
	}

}// end class
