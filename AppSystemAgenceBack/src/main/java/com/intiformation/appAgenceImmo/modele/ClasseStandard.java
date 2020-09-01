package com.intiformation.appAgenceImmo.modele;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.JoinColumn;


/**
 * Modèle de données pour une classe standard
 * 
 * @author hannahlevardon
 *
 */

@Entity
@Table(name = "classes_standards")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "idClasseStandard")
public class ClasseStandard implements Serializable{
	

	/*--------------- PROPRIETES ---------------*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_classe_standard")
	private Long idClasseStandard;
	
	@Column(name = "libelle")
	private String libelle; 
	
	// Type de bien : appartement, bureau, maison, terrain
	@Column(name = "type_de_bien")
	private String typeDeBien; 
	
	// Usage du bien : commercial ou habitation
	@Column(name = "usage_de_bien")
	private String usageDuBien;
	
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
	@ManyToMany (cascade= CascadeType.ALL)
	@JoinTable (name="classe_standard_client_assos",
			joinColumns=@JoinColumn(name="classe_standard_id"),
			inverseJoinColumns= @JoinColumn(name="personne_id"))
	private List<Client> clients;		
	
	
	/**
	 * Association entre classe standard et bien immobilier
	 * One classe standard pour Many biens immobiliers
	 */
	
	@OneToMany (cascade=CascadeType.ALL, mappedBy="classeStandard") 
	private List<BienImmobilier> biensImmobiliers;
	

	
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


	public String getUsageDuBien() {
		return usageDuBien;
	}


	public void setUsageDuBien(String usageDuBien) {
		this.usageDuBien = usageDuBien;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	

	
	

}//end classe














