package com.intiformation.appAgenceImmo.classMain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.intiformation.appAgenceImmo.dao.BienImmobilierRepository;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.Personne;
import com.intiformation.appAgenceImmo.modele.Proprietaire;
import com.intiformation.appAgenceImmo.service.BienImmobilierServiceImpl;
import com.intiformation.appAgenceImmo.ws_rest.BienImmobilierWebService;

/**
 * point d'entrée de notre appli => methode main
 * 
 * @author anais
 *
 */
@SpringBootApplication
@EntityScan(basePackages = { "com.intiformation.appAgenceImmo.modele"}) // détection des entités par spring
@ComponentScan(basePackages= {"com.intiformation.appAgenceImmo.service", 
		"com.intiformation.appAgenceImmo.ws_rest" })
@EnableJpaRepositories(basePackages = { "com.intiformation.appAgenceImmo.dao" }) // détection de la couche dao
public class AppSystemAgenceBackApplication implements CommandLineRunner {

	// Déclaration du Web Service
	@Autowired
	private BienImmobilierRepository bienImmo;
	

	@Autowired
	private BienImmobilierWebService bienImmoWS;
	
	
	
	public void setBienImmo(BienImmobilierRepository bienImmo) {
		this.bienImmo = bienImmo;
	}

	public void setBienImmoWS(BienImmobilierWebService bienImmoWS) {
		this.bienImmoWS = bienImmoWS;
	}

	// Déclaration de la classe pour la config de l'id dans le ws rest
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	/**
	 * Méthode main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Démarrage de l'application !");
		SpringApplication.run(AppSystemAgenceBackApplication.class, args);
		
	}// end main

	/**
	 * meth de l'interface : org.springframework.boot.CommandLineRunner methode qui
	 * s'execute après l'execution de l'app
	 */
	@Override
	public void run(String... args) throws Exception {

		System.out.println("++++++++ Dans la méthode run() +++++++");

		// Exposition de l'id du Bien Immobilier dans le ws rest
		repositoryRestConfiguration.exposeIdsFor(BienImmobilier.class, Personne.class, Proprietaire.class);

		// ==================================================
		// ============= Methodes de base ===================
		// ====== (UserRepository - JpaRepository) ==========
		// ==================================================
		/*
		// ====== WS REST BIEN IMMOBILIER ==========
		// Test AJOUT
		BienImmobilier bien1 = new BienImmobilier("maison", 20000.00);
		BienImmobilier bien2 = new BienImmobilier("Appartement", 20000.00);
		
		bienImmo.save(bien1);
		bienImmoWS.ajouterBienImmobilier(bien2);
		
		// Test GetAll
		List<BienImmobilier> listeBiensImmoBDD =  bienImmoWS.trouverTousBienImmobiliers();
		for (BienImmobilier bienImmobilier : listeBiensImmoBDD) {
			System.out.println(bienImmobilier.getStatut());
		}
		
		// Test find by Id
		
		BienImmobilier BienImmoaTrouver = bienImmoWS.trouverBienImmoViaId(2L); 
		System.out.println(BienImmoaTrouver.getRevenuCadastral());
		
		
		// Test modification 		
		BienImmoaTrouver.setRevenuCadastral(40000);
		bienImmoWS.modifierBienImmobilier(BienImmoaTrouver);
		*/

	}// end run()

	

}// end class