import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './composants/login/login.component';

import { BiensImmobiliersComponent } from './composants/biens-immobiliers/biens-immobiliers.component';
import { FormBiensImmobiliersComponent } from './composants/form-biens-immobiliers/form-biens-immobiliers.component';

const routes: Routes = [

  //route vers le login
  {path:"login" , component:LoginComponent},

  //route pour la gestion des biens immobiliers
  {path:"listBiens", component:BiensImmobiliersComponent},

  {path:"edit/:id", component:FormBiensImmobiliersComponent},

  //route pour les gestion des visites
  

  //route pour la gestion des proprietaire/locataire


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
