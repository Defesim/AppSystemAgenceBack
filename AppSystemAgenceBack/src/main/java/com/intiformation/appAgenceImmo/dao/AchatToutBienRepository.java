package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.AchatToutBien;

/**
 * Implementation de la couche DAO pour un achat de tout bien
 * implementation d'un ws REST 
 * @author hannahlevardon
 *
 */
@RepositoryRestResource
public interface AchatToutBienRepository extends JpaRepository<AchatToutBien, Long> {

}//end interface
