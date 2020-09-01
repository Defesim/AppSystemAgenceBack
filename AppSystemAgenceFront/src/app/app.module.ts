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
import { BiensImmobiliersComponent } from './composants/biens-immobiliers/biens-immobiliers.component';

// Pour l'internationalization 
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';


import {HttpClient} from '@angular/common/http';

import { CreateClientsComponent } from './composants/create/create-clients/create-clients.component';
import { CreateBiensImmobiliersComponent } from './composants/create/create-biens-immobiliers/create-biens-immobiliers.component';
import { CreateAdresseComponent } from './composants/create/create-adresse/create-adresse.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    VisitesComponent,
    ClientsProprioComponent,
    LoginComponent,
    BiensImmobiliersComponent,
    CreateClientsComponent,
    CreateBiensImmobiliersComponent,
    CreateAdresseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps : [HttpClient]
      }
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

export function HttpLoaderFactory(http:HttpClient){
  return new TranslateHttpLoader(http);
}
