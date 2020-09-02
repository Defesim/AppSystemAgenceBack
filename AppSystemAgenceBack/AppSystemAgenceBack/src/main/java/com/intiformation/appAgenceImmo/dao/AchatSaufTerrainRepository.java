package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.AchatSaufTerrain;

/**
 * Implementation de la couche DAO pour un achat hors terrain
 * implementation d'un ws REST pour un achat hors terrain
 * @author hannahlevardon
 *
 */

@RepositoryRestResource // annotation d'un WS Rest
public interface AchatSaufTerrainRepository extends JpaRepository<AchatSaufTerrain, Long> {

}//end interface
