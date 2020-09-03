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

@Component({
  selector: 'app-create-acquisition',
  templateUrl: './create-acquisition.component.html',
  styleUrls: ['./create-acquisition.component.css']
})
export class CreateAcquisitionComponent implements OnInit {

  acquisition : Acquisition;
  agentImmobilier : AgentImmobilier;
  client : Client;


  constructor(private bienImmobilierService:BiensImmobiliersService,
              private acquisitionService:AcquisitionsService,
              private router:Router,
              private activatedRouter: ActivatedRoute
              ) { 

  }//end constructor

  ngOnInit(): void {

    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idBien = +paramsMap.get("idBien");

      this.findBienImmoById(idBien);

    })
  }//end ngOnInit


  /**
   * Permet de récupérer le bien en cours d'acquisition
   * 
   * @param idEmploye 
   */
  findBienImmoById(idBien: number){

  this.bienImmobilierService.getBienImmoByIdFromWsRest(idBien).subscribe(

        (bienToUpdate) => {
          this.acquisition.bienImmobilier = bienToUpdate;
        }
      );

  }//end findBienImmoById

  saveOrUpdateBienImmo(){

  }

}
