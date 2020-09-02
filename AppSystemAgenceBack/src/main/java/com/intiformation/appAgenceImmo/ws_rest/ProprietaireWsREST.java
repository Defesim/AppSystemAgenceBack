package com.intiformation.appAgenceImmo.ws_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Proprietaire;
import com.intiformation.appAgenceImmo.service.IBienImmobillierService;
import com.intiformation.appAgenceImmo.service.IProprietaireService;

/**
 * implementation d'un ws rest pour un proprietaire
 * 
 * ws rest sera accessible via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/proprietaire/
 * 
 * @author anais
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController // déclare la classe comme WS rest
@RequestMapping("/ws-rest/proprietaire") // URL du WS rest
public class ProprietaireWsREST {
	
	// déclaration de la couche service + injection de la couche avec spring
	@Autowired
	private IProprietaireService proprietaireService;
	
	@Autowired
	private IBienImmobillierService bienImmobillierService;

	public void setProprietaireService(IProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
	
	public void setBienImmobillierService(IBienImmobillierService bienImmobillierService) {
		this.bienImmobillierService = bienImmobillierService;
	}
	
	
	
	// ----------- Methodes à exposer dans le WS REST ----------------
	
		/** GET ALL
		 * ==========
		 * meth exposée dans le ws rest pour récup la liste des proprietaires
		 * renvoie la liste des proprietaires en JSON
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/proprietaire/getAll
		 * @return la liste des visites
		 */
		@RequestMapping(value="/getAll", method=RequestMethod.GET)
		public List<Proprietaire> listAllProprietairesBdd(){
			
			return proprietaireService.trouverTout();
			
		}// end listAllProprietairesBdd
		

		
		/** ADD
		 * ======
		 * Méthode exposée dans le web service pour ajouter un proprietaire
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/proprietaire/save
		 */
		@PostMapping(value="/save")	
		public Proprietaire ajouterProprietaire(@RequestBody Proprietaire pProprietaire){
			return proprietaireService.ajouter(pProprietaire);
		}//end ajouterProprietaire

		
		/** GET BY ID
		 * ===========
		 * meth exposée dans le ws rest pour récup un proprietaire via son id
		 * requete en GET 
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/proprietaire/get-by-id/<id-proprietaire>
		 * @return le proprietaire
		 */
		@RequestMapping(value="/get-by-id/{id}", method=RequestMethod.GET)
		public Proprietaire proprietaireById(@PathVariable("id") Long pIdProprietaire) {
			return proprietaireService.trouverViaId(pIdProprietaire);
			
		}// end proprietaireById
		
		 
		/** UPDATE
		 * =========
		 * meth exposée dans le ws rest pour modifier un proprietaire
		 * recoit les données en JSON et les transforme en java via Jackson
		 * la transaction est assurée par @ReqauestBody 
		 * requete en PUT
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/proprietaire/update/<id-proprietaire>
		 */
		@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
		public void updateProprietaire(@RequestBody Proprietaire pProprietaire, @PathVariable("id") Long pIdProprietaire) {
			proprietaireService.modifier(pProprietaire);
			
		}// end updateProprietaire
		

		/** DELETE
		 * =========
		 * meth exposée dans le ws rest pour supprimer un Proprietaire via son id
		 * requete en GET 
		 * sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/proprietaire/delete/<id-proprietaire>
		 * 
		 * @return
		 */
		@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Boolean> deleteProprietaire(@PathVariable("id") Long pIdProprietaire){
			
			// suppression du proprio 
			proprietaireService.supprimerViaId(pIdProprietaire);
			
			// config de la réponse à renvoyer 
			/**
			 * Boolean.TRUE ==> pour suppression OK 
			 * HttpStatus.OK ==> renvoi d'un 200 OK
			 */
			return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
			
		}// end deleteProprietaire
		
		
		/** Recup du PROPRIETAIRE VIA UN BIEN IMMO
		 *  ========================================
		 *  meth exposée dans le ws rest pour récupérer le propriétaire d'un bien immobilier
		 *  requete en GET 
		 *  sera invoquée via l'url : http://localhost:8080/gestion-agence-immo/ws-rest/proprietaire/get-by-bien/<id-bien>
		 */
		@RequestMapping(value="get-by-bien/{idBien}", method=RequestMethod.GET)
		public Proprietaire trouverParLeBienDuProprio(@PathVariable("idBien") Long pBien) {
			
			BienImmobilier bienImmobilier = bienImmobillierService.trouverViaId(pBien);
			
			return proprietaireService.TrouverParLeBienDuProprio(bienImmobilier);
			
			
		}// end trouverParLeBienDuProprio
		
		
		
	

}// end class
