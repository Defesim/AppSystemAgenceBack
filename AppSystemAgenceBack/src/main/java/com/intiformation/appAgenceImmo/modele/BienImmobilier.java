package com.intiformation.appAgenceImmo.modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	// @OneToOne
	// @JoinColumn(name="adresse_id", referencedColumnName="id_adresse")
	// private Adresse adresse;

	// @ManyToOne
	// @JoinColumn(name="classe_standard_id", referencedColumnName="id_classe_standard")
	// private ClasseStandard classeStandard;

	// Permet de faire le lien entre le bien immobilier, l'agent qui gère la visite
	// et le client qui visite
	// @OneToMany(cascade=CascadeType.ALL, mappedBy="bienImmobilier")
	// private List<Visite> visites;

	// Permet de faire le lien entre l'agent responsable du contrat d'acquisition,
	// le client acheteur et le bien immobilier acquis
	// @OneToOne
	// @JoinColumn(name="acquisition_id", referencedColumnName="id_acquisition")
	// private Acquisition acquisition

	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public BienImmobilier() {
	}// end constructeur

	/**
	 * Constructeur chargé
	 * 
	 * @param idBienImmobilier
	 * @param statut
	 * @param dateDeSoumission
	 * @param dateDeMiseADisposition
	 * @param revenuCadastral
	 */
	public BienImmobilier(Long idBienImmobilier, String statut, Date dateDeSoumission, Date dateDeMiseADisposition,
			double revenuCadastral) {
		super();
		this.idBienImmobilier = idBienImmobilier;
		this.statut = statut;
		this.dateDeSoumission = dateDeSoumission;
		this.dateDeMiseADisposition = dateDeMiseADisposition;
		this.revenuCadastral = revenuCadastral;
	}// end constructeur

	/**
	 * Constructeur chargé sans l'id
	 * 
	 * @param statut
	 * @param dateDeSoumission
	 * @param dateDeMiseADisposition
	 * @param revenuCadastral
	 */
	public BienImmobilier(String statut, Date dateDeSoumission, Date dateDeMiseADisposition, double revenuCadastral) {
		super();
		this.statut = statut;
		this.dateDeSoumission = dateDeSoumission;
		this.dateDeMiseADisposition = dateDeMiseADisposition;
		this.revenuCadastral = revenuCadastral;
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

}// end class
