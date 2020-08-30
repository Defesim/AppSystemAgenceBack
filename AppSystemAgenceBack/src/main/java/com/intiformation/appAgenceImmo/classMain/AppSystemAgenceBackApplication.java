package com.intiformation.appAgenceImmo.classMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * point d'entrée de notre appli => methode main 
 * @author anais
 *
 */
@SpringBootApplication
@EntityScan(basePackages= {"com.intiformation.appAgenceImmo.modele"}) // détection des entités par spring 
@EnableJpaRepositories(basePackages= {"com.intiformation.appAgenceImmo.dao"} ) // détection de la couche dao
public class AppSystemAgenceBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSystemAgenceBackApplication.class, args);
		
	}// end main 

}// end class