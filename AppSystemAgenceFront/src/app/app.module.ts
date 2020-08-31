import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';

import {FormsModule} from '@angular/forms'

import { HeaderComponent } from './composants/header/header.component';
import { FooterComponent } from './composants/footer/footer.component';
import { VisitesComponent } from './composants/visites/visites.component';
import { ClientsProprioComponent } from './composants/clients-proprio/clients-proprio.component';
import { LoginComponent } from './composants/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    VisitesComponent,
    ClientsProprioComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
