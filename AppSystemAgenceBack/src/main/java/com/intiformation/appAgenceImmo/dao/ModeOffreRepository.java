package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.ModeOffre;

/**
 * Implementation de la couche DAO pour un mode d'offre
 * implementation d'un ws REST 
 * @author hannahlevardon
 *
 */
@RepositoryRestResource
public interface ModeOffreRepository extends JpaRepository<ModeOffre, Long> {

}//end interface
