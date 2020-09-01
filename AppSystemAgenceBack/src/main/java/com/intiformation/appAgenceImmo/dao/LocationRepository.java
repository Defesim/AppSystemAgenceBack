package com.intiformation.appAgenceImmo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.Location;

/**
 * Implementation de la couche DAO pour une location
 * implementation d'un ws REST 
 * @author hannahlevardon
 *
 */
@RepositoryRestResource // annotation d'un WS Rest
public interface LocationRepository extends JpaRepository<Location, Long> {

	
	public List<Location> findByMeuble (Boolean meuble);
	
	
}//end interface
