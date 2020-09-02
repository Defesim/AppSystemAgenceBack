import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './composants/login/login.component';

// composants type liste
import { BiensImmobiliersComponent } from './composants/biens-immobiliers/biens-immobiliers.component';

import { ClientsComponent } from './composants/clients/clients.component';
import { VisitesComponent } from './composants/visites/visites.component';
import {ProprietairesComponent} from './composants/proprietaires/proprietaires.component';

//composants pour la creation d'entité
import {CreateVisiteComponent} from './composants/create/create-visite/create-visite.component';
import { CreateBiensImmobiliersComponent } from './composants/create/create-biens-immobiliers/create-biens-immobiliers.component';
import { CreateClientsComponent } from './composants/create/create-clients/create-clients.component';
import { CreateProprietaireComponent } from './composants/create/create-proprietaire/create-proprietaire.component';


const routes: Routes = [

  //route vers le login
  {path:"login" , component:LoginComponent},

  //route pour la gestion des biens immobiliers
  {path:"listBiens", component:BiensImmobiliersComponent},
  {path:"editBien/:id",component:CreateBiensImmobiliersComponent },

  //route pour les gestion des visites
  {path:"visites", component:VisitesComponent},
  {path:"editVisite/:id", component:CreateVisiteComponent},
  

  //route pour la gestion des proprietaire
  {path:"proprio", component:ProprietairesComponent},
  {path:"editProprietaire/:id", component:CreateProprietaireComponent},


  //route pour la gestion des clients
  {path:"clients", component:ClientsComponent},
  {path:"editClient/:id", component:CreateClientsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
