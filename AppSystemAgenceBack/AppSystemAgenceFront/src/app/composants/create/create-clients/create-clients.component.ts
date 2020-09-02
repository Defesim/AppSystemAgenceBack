import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ClientsService } from 'src/app/services/clients.service';
import { Client } from 'src/app/modèles/Client';

@Component({
  selector: 'app-create-clients',
  templateUrl: './create-clients.component.html',
  styleUrls: ['./create-clients.component.css']
})
export class CreateClientsComponent implements OnInit {

  client: Client ;

  constructor(private clientService:ClientsService, 
              private router:Router,
              private activatedRouter: ActivatedRoute) { 
            
  }//end ctor

  ngOnInit(): void {

    // recup du param de l'id de l'url ( ref : route 'editBien/:id' de  app-routing.module.ts)
    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idClient = +paramsMap.get("id");

      this.findClientById(idClient);


    })
  }//end ngOnInit

  /**
   * Permet de  :
   *          -> cas id = 0 : (Ajout) init un objet vide pour l'ajout
   *          -> cad id > 0 : (Modif) appel du service pour la reucp des infos du bien à mod
   * 
   * @param idEmploye 
   */
  findClientById(idClient: number){

    if(idClient == 0){

      this.client =  {
        id_personne :null,
        adresse :null,
        email :null,
        listeClassesStandardsInteret: null,
        nom: null,
        prenom:null,
        telephonePrive:null       
      };

    }else{

      this.clientService.getClientByIdFromWsRest(idClient).subscribe(

        (bienToUpdate) => {
          this.client = bienToUpdate;
        }
      );

    }

  }//end findClientById


  saveOrUpdateClient(){

    // test de l'id du Client (AJOUT ou MODIF)
    if(this.client.id_personne == null){
      
      
      // => le bien n'a pas encore d'id <=> ajout
      this.clientService.ajouterClientViaWsRest(this.client).subscribe();

    }else{
      // => modification
      this.clientService.modifierClientViaWsRest(this.client).subscribe();

    }

    //redirection vers list
    this.router.navigate(['/clients']);

  }//end saveOrUpdateClient

}//end classe
