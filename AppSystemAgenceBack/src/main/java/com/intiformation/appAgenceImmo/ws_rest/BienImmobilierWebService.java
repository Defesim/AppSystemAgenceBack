package com.intiformation.appAgenceImmo.ws_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
import com.intiformation.appAgenceImmo.modele.Personne;
import com.intiformation.appAgenceImmo.modele.Proprietaire;
import com.intiformation.appAgenceImmo.service.IBienImmobillierService;

/**
 * Implémentation du Web Service Rest pour un bien immobilier
 * 
 * URL de base : http://localhost:8080/gestion-agence-immo/biensImmo/*
 * @author hannahlevardon
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclaration de la classe comme WS Rest
@RequestMapping("/biensImmo") // URL du WS REST pour des biens immobilier
public class BienImmobilierWebService {

	/*--------------- PROPRIETES ---------------*/
	
	// Déclaration de la couche service
	@Autowired
	private IBienImmobillierService bienImmoService;

	// Déclaration de la classe pour la config de l'id dans le ws rest
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	

	/**
	 * Setter de la couche service pour permettre l'injection Spring
	 * @param bienImmoService
	 */
	public void setBienImmoService(IBienImmobillierService bienImmoService) {
		this.bienImmoService = bienImmoService;
	} 
	
	/*--------------- METHODES A EXPOSER DANS LE WEB SERVICE ---------------*/
	
	/**
	 * Méthode exposée dans le web service pour ajouter un bien immobilier
	 * URL: 
	 * http://localhost:8080/gestion-agence-immo/biensImmo/save
	 * @param pBien
	 * @return
	 */
	@PostMapping(value="/save")	
	public BienImmobilier ajouterBienImmobilier(@RequestBody BienImmobilier pBien){
		return bienImmoService.ajouter(pBien);
	}//end ajouterBienImmobilier

	
	/**
	 * Méthode exposée dans le web service pour trouver la liste de toutes les biens immobiliers
	 * URL:
	 * http://localhost:8080/gestion-agence-immo/biensImmo/getAll
	 * @return
	 */
	@GetMapping(value="/getAll")	
	public List<BienImmobilier> trouverTousBienImmobiliers(){		
		//repositoryRestConfiguration.exposeIdsFor(BienImmobilier.class);	
		return bienImmoService.trouverTout() ;
	}// end trouverTousBienImmobiliers
	
	/**
	 * Méthode exposée dans le web service pour trouver la liste de toutes les biens immobiliers
	 * URL:
	 * http://localhost:8080/gestion-agence-immo/biensImmo/findById/{id}
	 * @return
	 */
	@GetMapping(value="/findById/{id}")
	public BienImmobilier trouverBienImmoViaId(@PathVariable("id") Long idBienImmo) {
		
		repositoryRestConfiguration.exposeIdsFor(BienImmobilier.class, Personne.class, Proprietaire.class);	
		BienImmobilier bienImmoATrouver = bienImmoService.trouverViaId(idBienImmo);	
		return bienImmoATrouver; 
	}//end trouverBienImmoViaId
	
	/**
	 * Méthode exposée dans le web service pour modifier un bien immobilier
	 * URL:
	 * http://localhost:8080/gestion-agence-immo/biensImmo/update
	 * @return
	 */
	@PutMapping(value="/update")
	public BienImmobilier modifierBienImmobilier(@RequestBody BienImmobilier pBIen) {		
		repositoryRestConfiguration.exposeIdsFor(BienImmobilier.class);	
		return bienImmoService.modifier(pBIen);	
	}//end modifierBienImmobilier
	
	/**
	 * Méthode exposée dans le web service pour supprimer un bien immobilier
	 * URL:
	 * http://localhost:8080/gestion-agence-immo/biensImmo/delete/{id}
	 * @return
	 */
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> supprimerBienImmobilier(@PathVariable("id") Long pIdBien ) {
		repositoryRestConfiguration.exposeIdsFor(BienImmobilier.class);	
		bienImmoService.supprimerViaId(pIdBien);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}//end supprimerBienImmobilier
	
	/**
	 * Méthode exposée dans le web service pour trouver une liste de biens immobilier pour une classe standard
	 * http://localhost:8080/gestion-agence-immo/biensImmo/getByClasseStandard/id
	 * @param pClasse
	 * @return
	 */
	@GetMapping(value="getByClasseStandard/{idClasseStandard}")
	public List<BienImmobilier> TrouverBienImmoParClasseStandard(@PathVariable("idClasseStandard") Long pIdClasse){		
		return bienImmoService.trouverParClasseStandard(pIdClasse);			
	}//end TrouverBeinImmoParClasseStandard
	
	// A IMPLEMENTER PAR LA SUITE :
	/**

	public List<BienImmobilier> trouverParProprietaire(Proprietaire pProprietaire) {
	
	public List<BienImmobilier> TrouverParModesOffre(ModeOffre pModeOffre) {
	
	public List<BienImmobilier> TrouverParVille(Adresse pAdresseVille) {
	
	public List<BienImmobilier> trouverParDateDeMiseADisposition(Date dateDeDispo) {
	}
	 */
	

}// end class
