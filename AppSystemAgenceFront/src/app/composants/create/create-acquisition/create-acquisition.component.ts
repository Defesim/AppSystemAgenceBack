import { Component, OnInit } from '@angular/core';

// Import des modeles
import { Acquisition } from 'src/app/modèles/Acquisition'
import { BienImmobilier } from 'src/app/modèles/BienImmobilier'
import { AgentImmobilier } from 'src/app/modèles/AgentImmobilier'
import { Client } from 'src/app/modèles/Client'

// Import des services
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { AcquisitionsService } from 'src/app/services/acquisitions.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AgentsService } from 'src/app/services/agents.service';
import { ClientsService } from 'src/app/services/clients.service';

@Component({
  selector: 'app-create-acquisition',
  templateUrl: './create-acquisition.component.html',
  styleUrls: ['./create-acquisition.component.css']
})
export class CreateAcquisitionComponent implements OnInit {

  bienImmobilier: BienImmobilier;
  acquisition : Acquisition;
  agentImmobilier : AgentImmobilier;
  client : Client;


  constructor(private bienImmobilierService:BiensImmobiliersService,
              private acquisitionService:AcquisitionsService,
              private router:Router,
              private activatedRouter: ActivatedRoute,
              private agentService: AgentsService,
              private cleintService: ClientsService
              ) { 

  }//end constructor

  ngOnInit(): void {

    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idBien = +paramsMap.get("idBien");

      this.findBienImmoById(idBien);

      this.acquisition ={
        agentImmobilier: null,
        bienImmobilier:null,
        client:null,
        dateAchat:null,
        idAcquisition:null,
        prixAchat:null,
        typeAcquisition:null,

      }
      
      this.acquisition.agentImmobilier={
        adresse:null, 
        email:null,
        id_personne:null,
        motDePasse:null,
        nom:null,
        prenom:null,
      }

      this.acquisition.client={
        adresse:null,
        email:null,
        id_personne:null,
        listeClassesStandardsInteret:null,
        nom:null,
        prenom:null,
        telephonePrive:null
      }

      this.acquisition.bienImmobilier={
        acquisition:null,
        adresse:null, 
        classeStandard:null,
        dateDeMiseADisposition:null,
        dateDeSoumission:null,
        idBienImmobilier:null,
        modeOffre:null,
        proprietaire:null,
        revenuCadastral:null,
        statut:null
      }
     
    })
  }//end ngOnInit


  /**
   * Permet de récupérer le bien en cours d'acquisition
   * 
   * 
   */
  findBienImmoById(idBien: number){

    if(idBien == 0){

      this.bienImmobilier =  {
        idBienImmobilier : null,
        dateDeMiseADisposition :  null,
        dateDeSoumission : null,
        revenuCadastral : null,
        statut : null,
        adresse : null,
        classeStandard : null,
        proprietaire: null,
        acquisition:null,
        modeOffre:null
      };

      this.bienImmobilier.acquisition = {
        agentImmobilier: null,
        bienImmobilier:null,
        client:null,
        dateAchat:null,
        idAcquisition:null,
        prixAchat:null,
        typeAcquisition:null,
      };

    }else{

      this.bienImmobilierService.getBienImmoByIdFromWsRest(idBien).subscribe(

        (bienToUpdate) => {
          this.bienImmobilier = bienToUpdate;
        }   
      );
    }
  }//end findBienImmoById

  saveOrUpdateBienImmo(){

    
    this.cleintService.getClientByIdFromWsRest(this.acquisition.client.id_personne).subscribe(
      (clientRetrouve) => {this.client = clientRetrouve}
    );

    this.agentService.getAgentImmobilierByIdFromWsRest(this.acquisition.agentImmobilier.id_personne).subscribe(
      (agentRetrouve) => { this.agentImmobilier = agentRetrouve}
    );

    console.log(this.client.id_personne);

    console.log(this.agentImmobilier.id_personne);

    this.acquisitionService.ajouterAcquisitionViaWsRest(this.acquisition).subscribe();
    
    console.log(this.acquisition.idAcquisition)

    

  }// end saveOrUpdateBienImmo

}//end classe
