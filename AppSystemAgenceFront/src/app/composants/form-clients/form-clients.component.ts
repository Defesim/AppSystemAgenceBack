import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

// classes pour implémenter le Model Driven Form
import {FormGroup, FormControl} from '@angular/forms'

// modeles nécessaires pour le client
import { Adresse } from 'src/app/modèles/Adresse';
import { Client } from 'src/app/modèles/Client';

@Component({
  selector: 'app-form-clients',
  templateUrl: './form-clients.component.html',
  styleUrls: ['./form-clients.component.css']
})
export class FormClientsComponent implements OnInit {

  adresse: Adresse = {
    idAdresse: null,
    rue: null,
    codePostal: null,
    ville: null
  }

  client: Client = {
    id_personne: null,
    nom: null,
    prenom: null,
    email: null, 
    adresse: null,
    telephonePrive: null,
    listeClassesStandardsInteret: null,
  }

  constructor(private router:Router,
              private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
  }

  saveOrUpdateEmploye(){
  }

}
