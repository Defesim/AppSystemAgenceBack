package com.intiformation.appAgenceImmo.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Modèle de données pour un mode d'offre
 * 
 * @author hannahlevardon
 *
 */

@Entity
@Table(name = "modes_offres")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class ModeOffre {
	
	/*--------------- PROPRIETES ---------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mode_offre")
	private Long idModeOffre;
	
	// type de l'offre: location ou achat
	@Column(name = "type_mode_offre")
	private String typeModeOffre; 
	
	
	/*--------------- ASSOCIATIONS ---------------*/
	
	/**
	 * Association entre mode d'offre et classe standard
	 * One mode d'offre pour many classes standards
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="modesOffre")
	private List<ClasseStandard> classesStandards;
	
	/*--------------- CONSTRUCTEURS ---------------*/
	/**
	 * Constructeur vide
	 */
	public ModeOffre() {
	}//end constructeur
	
	
	/*--------------- GETTER / SETTER ---------------*/

	public Long getIdModeOffre() {
		return idModeOffre;
	}

	public void setIdModeOffre(Long idModeOffre) {
		this.idModeOffre = idModeOffre;
	}

	public String getTypeModeOffre() {
		return typeModeOffre;
	}

	public void setTypeModeOffre(String typeModeOffre) {
		this.typeModeOffre = typeModeOffre;
	}


	public List<ClasseStandard> getClassesStandards() {
		return classesStandards;
	}


	public void setClassesStandards(List<ClasseStandard> classesStandards) {
		this.classesStandards = classesStandards;
	}

}//end class
