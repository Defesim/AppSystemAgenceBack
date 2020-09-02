import { Component, OnInit } from '@angular/core';
import {ClientsService} from 'src/app/services/clients.service';
import { ProprietairesService } from "src/app/services/proprietaires.service";
import {Client} from 'src/app/modèles/Client';

import { Router } from '@angular/router';
import { Proprietaire } from 'src/app/modèles/Proprietaire';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {
 
  /*__________________props_______________ */
  clients =[] ;
  prorietaires =[] ; // prop qui récupère la liste de sprop


  constructor(private clientService:ClientsService,
              private proprietaireService:ProprietairesService,
              private route:Router) {
      this.findAllClient();
      this.findAllProprietaires();
      ;
   }//end ctors


  ngOnInit(): void {
  }//end ngOnInit


  findAllClient(){
    this.clientService.getAllClientFromWsRest()
                      .subscribe(data=> this.clients = data);
  }//end findAllBiensImmo

  /**
   * Récupération de la liste des propriétaires via le WS-REST
   */
  findAllProprietaires(){
    this.proprietaireService.getAllProprietaireFromWsRest()
                            .subscribe(data => this.prorietaires = data);
  }//end findAllBiensImmo


  deleteClient(client:Client){
    
    this.clientService.supprimerClientViaWsRest(client).subscribe( ()=>{

      this.findAllClient();
    });

  }//end deleteClient


  editClient(idClient :number){

    this.route.navigate(['clients/edit', idClient]);

  }//end editClient


  deleteProprietaire(proprietaire:Proprietaire){
    
    this.proprietaireService.supprimerProprietaireViaWsRest(proprietaire).subscribe( ()=>{

      this.findAllProprietaires();
    });

  }//end deleteClient


  editProprietaire(idProprietaire :number){

    this.route.navigate(['editProprietaire', idProprietaire]);

  }//end editClient
   

}//end class
