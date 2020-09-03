import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

// Services
import { VisitesService } from 'src/app/services/visites.service';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { AgentsService } from 'src/app/services/agents.service';

// Modeles
import { BienImmobilier } from 'src/app/modèles/BienImmobilier';
import { Visite } from 'src/app/modèles/Visite';
import { AgentImmobilier } from 'src/app/modèles/AgentImmobilier';

@Component({
  selector: 'app-create-visite',
  templateUrl: './create-visite.component.html',
  styleUrls: ['./create-visite.component.css']
})
export class CreateVisiteComponent implements OnInit {

  //var de stockage de tous les biens immo
  biensImmobiliers = [];
  agentsImmobiliers = [];
  visite: Visite ;

  constructor(private agentsImmobiliersService: AgentsService,
              private visiteService:VisitesService, 
              private biensImmobiliersService:BiensImmobiliersService,
              private router:Router,
              private activatedRouter: ActivatedRoute) { 
                
                this.findAllBiensImmo();
                this.findAllAgentsImmo();
  
  }//end ctor

  ngOnInit(): void {

    // recup du param de l'id de l'url ( ref : route 'editBien/:id' de  app-routing.module.ts)
    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idVisite = +paramsMap.get("id");

      this.findVisiteById(idVisite);


    })
  }//end ngOnInit

  findAllBiensImmo(){
    this.biensImmobiliersService.getAllBienImmoFromWsRest()
                                .subscribe(data=> this.biensImmobiliers = data);
  }//end findAllBiensImmo

  findAllAgentsImmo(){
    this.agentsImmobiliersService.getAllAgentImmobilierFromWsRest()
                                .subscribe(data=> this.agentsImmobiliers = data);
  }//end findAllBiensImmo


  findVisiteById(idVisite: number){

    if(idVisite == 0){

      this.visite =  {
        agentImmobilier:null,
        bienImmobilier:null,
        dateVisite:null,
        idVisite:null,
        client:null
      };

      this.visite.bienImmobilier = {
        adresse: null,
        classeStandard: null,
        dateDeMiseADisposition: null,
        dateDeSoumission: null,
        idBienImmobilier: null,
        revenuCadastral: null,
        statut: null,
        proprietaire:null,
        acquisition:null,
        modeOffre:null
      };

      this.visite.agentImmobilier = {
        id_personne:null,
        nom:null,
        prenom:null,
        email:null,
        adresse:null,
        motDePasse:null
      };

      this.visite.client = {
        id_personne:null,
        nom:null,
        prenom:null,
        email:null,
        adresse:null,
        telephonePrive:null,
        listeClassesStandardsInteret: null

      };

    }else{

      this.visiteService.getVisiteByIdFromWsRest(idVisite).subscribe(

        (visiteToUpdate) => {
          this.visite = visiteToUpdate;
        }
      );

    }

  }//end findVisiteById


  saveOrUpdateVisite(){
    // test de l'id du Visite (AJOUT ou MODIF)
    this.agentsImmobiliersService.getAgentImmobilierByIdFromWsRest(this.visite.agentImmobilier.id_personne).subscribe(
      (agentImmobilierRetrouve) => {this.visite.agentImmobilier = agentImmobilierRetrouve;}
    );

    this.biensImmobiliersService.getBienImmoByIdFromWsRest(this.visite.bienImmobilier.idBienImmobilier).subscribe(
      (bienImmobilierRetrouve) => {this.visite.bienImmobilier = bienImmobilierRetrouve;}
     );

    if(this.visite.idVisite == null){
      console.log(this.visite.idVisite)
      console.log(this.visite.agentImmobilier.id_personne)
      console.log(this.visite.bienImmobilier.idBienImmobilier)
      console.log(this.visite.client.id_personne)
      // => le bien n'a pas encore d'id <=> ajout
      this.visiteService.ajouterVisiteViaWsRest(this.visite).subscribe();

    }
    
    else{
    
      // => modification
      this.visiteService.modifierVisiteViaWsRest(this.visite).subscribe();

    }

    //redirection vers list
    this.router.navigate(['/visites']);

  }//end saveOrUpdateVisite
}//end class