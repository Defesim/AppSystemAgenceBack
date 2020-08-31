import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './composants/login/login.component';

import { BiensImmobiliersComponent } from './composants/biens-immobiliers/biens-immobiliers.component';

const routes: Routes = [

  //route vers le login
  {path:"login" , component:LoginComponent},

  {path:"listBiens", component:BiensImmobiliersComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
