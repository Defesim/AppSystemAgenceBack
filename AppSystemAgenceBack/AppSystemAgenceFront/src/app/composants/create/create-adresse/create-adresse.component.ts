import { Component, OnInit } from '@angular/core';
import { Adresse } from 'src/app/modèles/Adresse';
import {AdressesService} from 'src/app/services/adresses.service'
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-create-adresse',
  templateUrl: './create-adresse.component.html',
  styleUrls: ['./create-adresse.component.css']
})
export class CreateAdresseComponent implements OnInit {

  adresse: Adresse ;

  constructor(private adresseService:AdressesService, 
              private router:Router,
              private activatedRouter: ActivatedRoute) { 
            
  }//end ctor

  ngOnInit(): void {

    // recup du param de l'id de l'url ( ref : route 'editBien/:id' de  app-routing.module.ts)
    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idAdresse = +paramsMap.get("id");

      this.findAdresseById(idAdresse);


    })
  }//end ngOnInit

  /**
   * Permet de  :
   *          -> cas id = 0 : (Ajout) init un objet vide pour l'ajout
   *          -> cad id > 0 : (Modif) appel du service pour la reucp des infos du bien à mod
   * 
   * @param idEmploye 
   */
  findAdresseById(idAdresse: number){

    if(idAdresse == 0){

      this.adresse =  {
        rue:null,
        codePostal:null,
        ville:null,
        idAdresse:null      
      };

    }else{

      this.adresseService.getAdresseByIdFromWsRest(idAdresse).subscribe(

        (adresseToUpdate) => {
          this.adresse = adresseToUpdate;
        }
      );

    }

  }//end findAdresseById


  saveOrUpdateAdresse(){

    // test de l'id du Adresse (AJOUT ou MODIF)
    if(this.adresse.idAdresse == null){
      
      
      // => le bien n'a pas encore d'id <=> ajout
      this.adresseService.ajouterAdresseViaWsRest(this.adresse).subscribe();

    }else{
      // => modification
      this.adresseService.modifierAdresseViaWsRest(this.adresse).subscribe();

    }

    //redirection vers list
    this.router.navigate(['/adresses']);

  }//end saveOrUpdateAdresse
}//end class
