package com.intiformation.appAgenceImmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intiformation.appAgenceImmo.modele.Adresse;

/**
 * Implementation de la couche "DAO" pour une adresse
 * implementation d'un ws REST pour une adresse
 * @author anais
 *
 */
@RepositoryRestResource
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}// end interface
