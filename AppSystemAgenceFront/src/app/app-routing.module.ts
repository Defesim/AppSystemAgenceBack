import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './composants/login/login.component';

import { BiensImmobiliersComponent } from './composants/biens-immobiliers/biens-immobiliers.component';
import { ClientsProprioComponent } from './composants/clients-proprio/clients-proprio.component';

const routes: Routes = [

  //route vers le login
  {path:"login" , component:LoginComponent},

  //route pour la gestion des biens immobiliers
  {path:"listBiens", component:BiensImmobiliersComponent},

  //route pour les gestion des visites
  

  //route pour la gestion des proprietaire/locataire

  //route pour la gestion des clients
  {path:"clients", component:ClientsProprioComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
