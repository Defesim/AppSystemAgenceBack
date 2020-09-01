package com.intiformation.appAgenceImmo.classMain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.intiformation.appAgenceImmo.dao.AcquisitionRepository;
import com.intiformation.appAgenceImmo.dao.AgentImmobilierRepository;
import com.intiformation.appAgenceImmo.dao.BienImmobilierRepository;
import com.intiformation.appAgenceImmo.dao.ClasseStandardRepository;
import com.intiformation.appAgenceImmo.dao.ClientRepository;
import com.intiformation.appAgenceImmo.dao.ModeOffreRepository;
import com.intiformation.appAgenceImmo.dao.ProprietaireRepository;
import com.intiformation.appAgenceImmo.dao.VisiteRepository;
import com.intiformation.appAgenceImmo.modele.Acheteur;
import com.intiformation.appAgenceImmo.modele.Acquisition;
import com.intiformation.appAgenceImmo.modele.Adresse;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.BienImmobilier;
import com.intiformation.appAgenceImmo.modele.ClasseStandard;
import com.intiformation.appAgenceImmo.modele.Client;
import com.intiformation.appAgenceImmo.modele.Image;
import com.intiformation.appAgenceImmo.modele.Locataire;
import com.intiformation.appAgenceImmo.modele.ModeOffre;
import com.intiformation.appAgenceImmo.modele.Proprietaire;
import com.intiformation.appAgenceImmo.modele.Visite;


/**
 * point d'entrée de notre appli => methode main 
 * @author anais
 *
 */
@SpringBootApplication
@EntityScan(basePackages= {"com.intiformation.appAgenceImmo.modele"}) // détection des entités par spring 
@EnableJpaRepositories(basePackages= {"com.intiformation.appAgenceImmo.dao"} ) // détection de la couche dao
public class AppSystemAgenceBackApplication implements CommandLineRunner{

	// déclaration de la couche DAO pour la tester
	@Autowired
	private ProprietaireRepository proprietaireRepository;
	
	@Autowired
	private AgentImmobilierRepository agentImmobilierRepository;
	
	@Autowired
	private ClasseStandardRepository classeStandardRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private BienImmobilierRepository bienImmobilierRepository;
	
	@Autowired
	private VisiteRepository visiteRepository;
	
	@Autowired
	private ModeOffreRepository modeOffreRepository;
	
	private AcquisitionRepository acquisitionRepository;
	
	/**
	 * méthode main : point de démarrage de l'app
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AppSystemAgenceBackApplication.class, args);
		System.out.println(".. Démarrage de l'app ! ...");
	}// end main 

	/**
	 * 	> methode de l'interface @see org.springframework.boot.CommandLineRunner
	 * 	> s'execute après l'exécution de l'application.
	 */
	@Override
	public void run(String... args) throws Exception {
		
		/*=====================================================================*/
		/*==== Méthodes de base de la DAO (UserRepository - JPARepository) ====*/
		/*=====================================================================*/
		
		/*-------------------- Test DAO : ajout ---------------------*/
		
		// -> Adresse à ajouter
		Adresse adresse1 = new Adresse("77, rue du Fossé des Tanneurs", "83000", "TOULON");
		Adresse adresse2 = new Adresse("40, avenue Voltaire", "64700", "MAISONS-ALFORT");
		Adresse adresse3 = new Adresse("56, rue du Général Ailleret", "62300", "LENS");
		Adresse adresse4 = new Adresse("5, Place du Jeu de Paume", "18100", "VIERZON");
		Adresse adresse5 = new Adresse("7, rue du Château", "78100", "SAINT-GERMAIN-EN-LAYE");
		Adresse adresse6 = new Adresse("57, place Stanislas", "54000", "NANCY");
		Adresse adresse7 = new Adresse("25, rue Adolphe Wurtz", "97231", "LE ROBERT");
		Adresse adresse8 = new Adresse("43, Rue Frédéric Chopin", "78000", "VERSAILLES");
		Adresse adresse9 = new Adresse("23, Square de la Couronne", "75002", "PARIS");
		Adresse adresse10 = new Adresse("19, rue Jean Vilar", "60000", "BEAUVAIS");
		Adresse adresse11 = new Adresse("89, Boulevard de Normandie", "57600", "FORBACH");
		Adresse adresse12 = new Adresse("3, Place de la Madeleine", "75010 ", "PARIS");
		Adresse adresse13 = new Adresse("48, rue des lieutemants Thomazo", "39100", "DOLE");
		Adresse adresse14 = new Adresse("46, rue des six frères Ruellan", "13300", "SALON-DE-PROVENCE");
		Adresse adresse15 = new Adresse("38, Rue du Limas", "64100", "BAYONNE");
		
		// -> Agent immobilier à ajouter
		AgentImmobilier agentImmobilier1 = new AgentImmobilier("Duval", "Michel", "michel.duval@agenceimmo.com", adresse1 , "111");
		AgentImmobilier agentImmobilier2 = new AgentImmobilier("Chabot", "Aurélie", "aurelie.chabot@agenceimmo.com", adresse2 , "111");
		/*
		agentImmobilierRepository.save(agentImmobilier1);
		agentImmobilierRepository.save(agentImmobilier2);
		*/
		
		// -> Propriétaire à ajouter
		Proprietaire proprietaire1 = new Proprietaire("Pépin", "Mireille", "mireille.pepin@gmail.com", adresse3 , "02.45.84.65.25", "06.84.25.14.02");
		Proprietaire proprietaire2 = new Proprietaire("Leblanc", "Grégoire", "gregoire.leblanc@gmail.com", adresse4 ,"02.14.35.26.88", "06.45.45.85.72");
		Proprietaire proprietaire3 = new Proprietaire("Bonnet", "Claudette ", "claudette.bonnet@gmail.com", adresse5 , "04.74.20.15.55", "06.42.42.42.22");
		Proprietaire proprietaire4 = new Proprietaire("Veronneau", "Marine", "marine.veronneau@gmail.com", adresse6 ,"05.42.52.42.77", "06.75.42.88.42");
		Proprietaire proprietaire5 = new Proprietaire("Grondin", "Eloise", "eloise.grondin@gmail.com", adresse7 , "05.45.57.45.23", "06.66.33.45.45");
		Proprietaire proprietaire6 = new Proprietaire("Lepetit", "Marc", "marc.lepetit@gmail.com", adresse8 ,"03.14.35.26.88", "06.12.45.57.45");
		Proprietaire proprietaire7 = new Proprietaire("Porte", "Pascal", "pascal.porte@gmail.com", adresse9 , "04.45.42.44.31", "06.14.20.45.74");
		Proprietaire proprietaire8 = new Proprietaire("Harada", "Mikiyasu", "mikiyasu.harada@gmail.com", adresse10 ,"02.10.42.42.71", "06.44.53.42.10");
		Proprietaire proprietaire9 = new Proprietaire("Awad", "Reda", "reda.awad@gmail.com", adresse11 , "01.14.21.01.40", "06.44.12.75.14");
		/*
		proprietaireRepository.save(proprietaire1);
		proprietaireRepository.save(proprietaire2);
		proprietaireRepository.save(proprietaire3);
		proprietaireRepository.save(proprietaire4);
		proprietaireRepository.save(proprietaire5);
		proprietaireRepository.save(proprietaire6);
		proprietaireRepository.save(proprietaire7);
		proprietaireRepository.save(proprietaire8);
		proprietaireRepository.save(proprietaire9);
		*/		
		// -> Classe standard
		ClasseStandard classeStandard1 = new ClasseStandard("Appartement centre ville", "Appartement", "Habitation", "Appartement à louer - Centre Ville", 1200.00, 25);
		ClasseStandard classeStandard2 = new ClasseStandard("Appartement banlieue", "Appartement", "Habitation", "Appartement à louer - Proche centre ville, Banlieue", 700.00, 20);
		ClasseStandard classeStandard3 = new ClasseStandard("Maison proche banlieue", "Maison", "Habitation", "Maison à acheter - Zone périurbaine", 600000.00, 80);
		ClasseStandard classeStandard4 = new ClasseStandard("Villa", "Maison", "Habitation", "Villa de location", 3200.00, 220);
		ClasseStandard classeStandard5 = new ClasseStandard("Terrain", "Terrain", "Habitation", "Terrain à vendre - Lotissement ", 260000, 10);
		ClasseStandard classeStandard6 = new ClasseStandard("Bureau", "Bureau", "Commercial", "Bureau à louer - Centre ville", 1300.00, 45);
		/*
		classeStandardRepository.save(classeStandard1);
		classeStandardRepository.save(classeStandard2);
		classeStandardRepository.save(classeStandard3);
		classeStandardRepository.save(classeStandard4);
		classeStandardRepository.save(classeStandard5);
		classeStandardRepository.save(classeStandard6);
		*/
		List<ClasseStandard> listeClassesStandardsInteretClient1 = new ArrayList<>();
		listeClassesStandardsInteretClient1.add(classeStandard1);
		listeClassesStandardsInteretClient1.add(classeStandard2);
		
		System.out.println(listeClassesStandardsInteretClient1);
		
		List<ClasseStandard> listeClassesStandardsInteretClient2 = new ArrayList<>();
		listeClassesStandardsInteretClient2.add(classeStandard3);
		listeClassesStandardsInteretClient2.add(classeStandard5);
		
		List<ClasseStandard> listeClassesStandardsInteretClient3 = new ArrayList<>();
		listeClassesStandardsInteretClient3.add(classeStandard4);
		
		List<ClasseStandard> listeClassesStandardsInteretClient4 = new ArrayList<>();
		listeClassesStandardsInteretClient4.add(classeStandard6);
		
		
		// -> Client à ajouter
		Client client1 = new Client("Forest", "Mathilda", "mathilda.forest@gmail.com", adresse12, "07.20.95.56.14", listeClassesStandardsInteretClient1);
		Client client2 = new Client("Rodrigues", "Paul", "paul.rodrigues@gmail.com", adresse13, "07.78.25.63.63", listeClassesStandardsInteretClient2);
		Client client3 = new Client("Jalbert", "Isaac", "isaac.jalbert@gmail.com", adresse14, "06.30.52.14.22", listeClassesStandardsInteretClient3);
		Client client4 = new Client("Arnoux", "Jules", "jules.arnoux@gmail.com", adresse15, "06.47.58.54.14", listeClassesStandardsInteretClient4);
		Client client5 = new Client("Vasilyev", "Dana", "dana.vasilyev@gmail.com", adresse13, "07.78.25.63.63", listeClassesStandardsInteretClient2);
		Client client6 = new Client("Loudain", "Antoine", "antoine.loudain@gmail.com", adresse14, "06.30.52.14.22", listeClassesStandardsInteretClient3);
		Client client7 = new Client("McLean", "Allan", "alan.mclean@gmail.com", adresse15, "06.47.58.54.14", listeClassesStandardsInteretClient4);
		/*
		clientRepository.save(client1);
		clientRepository.save(client2);
		clientRepository.save(client3);
		clientRepository.save(client4);
		*/
		System.out.println(client1);
		
		// -> Visite
		Visite visite1 = new Visite(new Date(2020, 07, 22), client1, agentImmobilier1);
		List<Visite> listeVisiteBien1 = new ArrayList<>();
		listeVisiteBien1.add(visite1);
		//Visite visite2 = new Visite(new Date(2020, 07, 24), client1, agentImmobilier1);
				
		Visite visite3 = new Visite(new Date(2020, 10, 21), client2, agentImmobilier1);
		List<Visite> listeVisiteBien3 = new ArrayList<>();
		listeVisiteBien3.add(visite3);
				
		Visite visite4 = new Visite(new Date(2020, 06, 11), client3, agentImmobilier1);
		List<Visite> listeVisiteBien4 = new ArrayList<>();
		listeVisiteBien4.add(visite4);
		Visite visite5 = new Visite(new Date(2020, 06, 22), client3, agentImmobilier1);
		List<Visite> listeVisiteBien5 = new ArrayList<>();
		listeVisiteBien4.add(visite5);
		Visite visite6 = new Visite(new Date(2020, 06, 24), client3, agentImmobilier1);
		List<Visite> listeVisiteBien6 = new ArrayList<>();
		listeVisiteBien4.add(visite6);
		
		
		Visite visite7 = new Visite(new Date(2020, 07, 20), client4, agentImmobilier2);
		List<Visite> listeVisiteBien7 = new ArrayList<>();
		listeVisiteBien7.add(visite7);
				
		Visite visite8 = new Visite(new Date(2020, 11, 10), client5, agentImmobilier2);
		List<Visite> listeVisiteBien8 = new ArrayList<>();
		listeVisiteBien8.add(visite8);
		Visite visite9 = new Visite(new Date(2020, 11, 12), client6, agentImmobilier2);
		List<Visite> listeVisiteBien9 = new ArrayList<>();
		listeVisiteBien9.add(visite9);
				
		//Visite visite10 = new Visite(new Date(2020, 12, 04), client7, agentImmobilier2);
				
		/*
		visiteRepository.save(visite1);
		visiteRepository.save(visite2);
		visiteRepository.save(visite3);
		visiteRepository.save(visite4);
		visiteRepository.save(visite5);
		visiteRepository.save(visite6);
		visiteRepository.save(visite7);
		visiteRepository.save(visite8);
		visiteRepository.save(visite9);
		visiteRepository.save(visite10);
		*/
		

		
		// -> Bien immobilier
		BienImmobilier bienImmobilier1 = new BienImmobilier("A louer", new Date(2020, 07, 05), new Date(2020, 07, 20), 803.00, classeStandard1, proprietaire1, listeVisiteBien1);
		//BienImmobilier bienImmobilier2 = new BienImmobilier("A louer", new Date(2020, 04, 22), new Date(2020, 04, 22), 1001.00, classeStandard1, proprietaire1, visite2);
		BienImmobilier bienImmobilier3 = new BienImmobilier("A louer", new Date(2020, 07, 10), new Date(2020, 10, 01), 1270.00, classeStandard2, proprietaire2, listeVisiteBien3);
		//BienImmobilier bienImmobilier4 = new BienImmobilier("A acheter", new Date(2020, 05, 26), new Date(2020, 07, 22), 1014.00, classeStandard3, proprietaire3, listeVisiteBien4);
		//BienImmobilier bienImmobilier5 = new BienImmobilier("Vendu", new Date(2020, 02, 12), new Date(2020, 06, 03), 1024.00, classeStandard3, proprietaire4, listeVisiteBien5);
		BienImmobilier bienImmobilier6 = new BienImmobilier("A acheter", new Date(2020, 06, 07), new Date(2020, 05, 14), 1425.00, classeStandard3, proprietaire5, listeVisiteBien5);
		BienImmobilier bienImmobilier7 = new BienImmobilier("A louer", new Date(2020, 01, 07), new Date(2020, 01, 13), 1327.00, classeStandard4, proprietaire6, listeVisiteBien6);
		//BienImmobilier bienImmobilier8 = new BienImmobilier("A louer", new Date(2020, 03, 05), new Date(2020, 04, 11), 1178.00, classeStandard4, proprietaire7, listeVisiteBien7);
		BienImmobilier bienImmobilier9 = new BienImmobilier("A acheter", new Date(2020, 06, 13), new Date(2020, 06, 25), 1478.00, classeStandard5, proprietaire8, listeVisiteBien8);
		//BienImmobilier bienImmobilier10 = new BienImmobilier("A louer", new Date(2020, 04, 15), new Date(2020, 07, 24), 756.00, classeStandard6, proprietaire9, visite10);
		BienImmobilier bienImmobilier11 = new BienImmobilier("A louer", new Date(2020, 05, 12), new Date(2020, 06, 18), 652.00, classeStandard6, proprietaire9, listeVisiteBien9);
		
		bienImmobilierRepository.save(bienImmobilier1);
		//bienImmobilierRepository.save(bienImmobilier2);
		bienImmobilierRepository.save(bienImmobilier3);
		//bienImmobilierRepository.save(bienImmobilier4);
		//bienImmobilierRepository.save(bienImmobilier5);
		bienImmobilierRepository.save(bienImmobilier6);
		bienImmobilierRepository.save(bienImmobilier7);
		//bienImmobilierRepository.save(bienImmobilier8);
		bienImmobilierRepository.save(bienImmobilier9);
		//bienImmobilierRepository.save(bienImmobilier10);
		bienImmobilierRepository.save(bienImmobilier11);
		
		/*
		// -> Modes d'offres
		ModeOffre modeOffre1 = new ModeOffre("A louer", bienImmobilier1);
		//ModeOffre modeOffre2 = new ModeOffre("A louer", bienImmobilier2);
		ModeOffre modeOffre3 = new ModeOffre("A louer", bienImmobilier3);
		ModeOffre modeOffre4 = new ModeOffre("A acheter", bienImmobilier4);
		ModeOffre modeOffre5 = new ModeOffre("Vendu", bienImmobilier5);
		ModeOffre modeOffre6 = new ModeOffre("A acheter", bienImmobilier6);
		ModeOffre modeOffre7 = new ModeOffre("A louer", bienImmobilier7);
		ModeOffre modeOffre8 = new ModeOffre("A louer", bienImmobilier8);
		ModeOffre modeOffre9 = new ModeOffre("A acheter", bienImmobilier9);
		//ModeOffre modeOffre10 = new ModeOffre("A louer", bienImmobilier10);
		ModeOffre modeOffre11 = new ModeOffre("A louer", bienImmobilier11);
			
		modeOffreRepository.save(modeOffre1);
		modeOffreRepository.save(modeOffre2);
		modeOffreRepository.save(modeOffre3);
		modeOffreRepository.save(modeOffre4);
		modeOffreRepository.save(modeOffre5);
		modeOffreRepository.save(modeOffre6);
		modeOffreRepository.save(modeOffre7);
		modeOffreRepository.save(modeOffre8);
		modeOffreRepository.save(modeOffre9);
		modeOffreRepository.save(modeOffre10);
		modeOffreRepository.save(modeOffre11);
		*/
		
	}// end run
	
	

}// end class