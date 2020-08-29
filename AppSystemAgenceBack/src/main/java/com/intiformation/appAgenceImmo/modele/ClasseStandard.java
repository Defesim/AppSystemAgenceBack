package com.intiformation.appAgenceImmo.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Modèle de données pour une classe standard
 * 
 * @author hannahlevardon
 *
 */

@Entity
@Table(name = "classes_standards")
public class ClasseStandard {
	

	/*--------------- PROPRIETES ---------------*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_classe_standard")
	private Long idClasseStandard;
	
	@Column(name = "libelle")
	private String libelle; 
	
	@Column(name = "type_de_bien")
	private String typeDeBien; 
	
	@Column(name = "description")
	private String description; 
	
	@Column(name = "prix_maximum")
	private double prixMaximum;
	
	@Column(name = "superficie_minimum")
	private int superficieMinimum; 
	
	
	/*--------------- ASSOCIATIONS ---------------*/

	/**
	 * Association entre classe standard et client:
	 * Many clients pour many classes standards
	 */
	/*
	@ManyToMany (cascade= CascadeType.ALL)
	@JoinTable (name="classe_standard_client_assos",
			joinColumns=@JoinColumn(name="classe_standard_id"),
			inverseJoinColumns= @JoinColumn(name="client_id"))
	private List<Client> clients;		
	*/
	
	/**
	 * Association entre classe standard et bien immobilier
	 * One classe standard pour Many biens immobiliers
	 */
	
	@OneToMany (cascade=CascadeType.ALL, mappedBy="classeStandard") 
	private List<BienImmobilier> biensImmobiliers;
	
	
	/**
	 * Association entre classe standard et mode d'offre 
	 * Many classe standard pour many modes d'offre 
	 */
	/*
	 @ManyToMany (cascade= CascadeType.ALL)
   	 @JoinTable (name="classe_standard_mode_offre_assos",
			joinColumns=@JoinColumn(name="classe_standard_id"),
			inverseJoinColumns= @JoinColumn(name="mode_offre_id"))
	 private List<ModeOffre> modesOffre;
	 */
	
	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public ClasseStandard() {
	}// end constructeur

	
	/*--------------- GETTER / SETTER ---------------*/

	public Long getIdClasseStandard() {
		return idClasseStandard;
	}

	public void setIdClasseStandard(Long idClasseStandard) {
		this.idClasseStandard = idClasseStandard;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getTypeDeBien() {
		return typeDeBien;
	}

	public void setTypeDeBien(String typeDeBien) {
		this.typeDeBien = typeDeBien;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixMaximum() {
		return prixMaximum;
	}

	public void setPrixMaximum(double prixMaximum) {
		this.prixMaximum = prixMaximum;
	}

	public int getSuperficieMinimum() {
		return superficieMinimum;
	}

	public void setSuperficieMinimum(int superficieMinimum) {
		this.superficieMinimum = superficieMinimum;
	}

	public List<BienImmobilier> getBiensImmobiliers() {
		return biensImmobiliers;
	}

	public void setBiensImmobiliers(List<BienImmobilier> biensImmobiliers) {
		this.biensImmobiliers = biensImmobiliers;
	}
	

	
	

}//end classe














