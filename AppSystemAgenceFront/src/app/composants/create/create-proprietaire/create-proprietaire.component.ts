import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProprietairesService } from 'src/app/services/proprietaires.service';
import { Proprietaire } from 'src/app/modèles/Proprietaire';

@Component({
  selector: 'app-create-proprietaire',
  templateUrl: './create-proprietaire.component.html',
  styleUrls: ['./create-proprietaire.component.css']
})
export class CreateProprietaireComponent implements OnInit {

  // Propriété 
  prorpietaire: Proprietaire;

  // COnstructeur
  constructor(private proprioService: ProprietairesService,
    private router: Router,
    private activatedRouter: ActivatedRoute) {


  }//end ctor

  ngOnInit(): void {

    // Récupération du param de l'id ee l'url 
    this.activatedRouter.paramMap.subscribe((paramsMap) => {

      const idProprietaire = +paramsMap.get("id");

      this.findProprietaireById(idProprietaire);

    })//end ndOnInit
  }

  findProprietaireById(idProprietaire: number) {

    if (idProprietaire == 0) {

      this.prorpietaire = {

        id_personne: null,
        adresse: null,
        email: null,
        nom: null,
        prenom: null,
        telephonePrive: null,
        telephonePro: null,
        listeDesBiensDuProprio: null
      };

    } else{

      this.proprioService.getProprietaireByIdFromWsRest(idProprietaire).subscribe(
        (proprioToUpdate) => { this.prorpietaire = proprioToUpdate}
      )
    }

  }//end findProprietaireById

  saveOrUpdateProprietaire(){

    // test de l'id du Client (AJOUT ou MODIF)
    if(this.prorpietaire.id_personne == null){
      
      
      // => le bien n'a pas encore d'id <=> ajout
      this.proprioService.ajouterProprietaireViaWsRest(this.prorpietaire).subscribe();

    }else{
      // => modification
      this.proprioService.ajouterProprietaireViaWsRest(this.prorpietaire).subscribe();

    }

    //redirection vers list
    this.router.navigate(['/clients']);

  }//end saveOrUpdateClient


}//end classe
