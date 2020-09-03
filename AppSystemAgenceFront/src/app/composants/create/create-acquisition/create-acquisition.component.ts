import { Component, OnInit } from '@angular/core';

// Import des modeles
import { Acquisition } from 'src/app/modèles/Acquisition'
import { BienImmobilier } from 'src/app/modèles/BienImmobilier'
import { AgentImmobilier } from 'src/app/modèles/AgentImmobilier'
import { Client } from 'src/app/modèles/Client'

@Component({
  selector: 'app-create-acquisition',
  templateUrl: './create-acquisition.component.html',
  styleUrls: ['./create-acquisition.component.css']
})
export class CreateAcquisitionComponent implements OnInit {

  acquisition : Acquisition;
  bienImmobilier : BienImmobilier;
  agentImmobilier : AgentImmobilier;
  client : Client;

  idAcquisition:number;
  typeAcquisition:string;
  dateAchat: string; //Date
  prixAchat:number;
  bienImmobilier:BienImmobilier;
  agentImmobilier: AgentImmobilier;
  client:Client;

  constructor() { }

  ngOnInit(): void {
  }

}
