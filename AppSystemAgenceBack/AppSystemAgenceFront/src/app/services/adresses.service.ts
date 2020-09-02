import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {Adresse} from 'src/app/modèles/Adresse';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AdressesService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/adresses";


  constructor(private httpClient: HttpClient) { }


  getAllAdresseFromWsRest(): Observable<Adresse[]>{
    return this.httpClient.get<Adresse[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllAdresseFromWsRest

  ajouterAdresseViaWsRest(adresse: Adresse): Observable<Adresse>{

    return this.httpClient.post<Adresse>(this.WS_REST_BASE_URL+"/save", adresse);

  }

  supprimerAdresseViaWsRest(adresse:Adresse): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + adresse.idAdresse);

  }//end supprimerAdresseViaWsRest

  getAdresseByIdFromWsRest(pAdresseId : number): Observable<Adresse>{

    return this.httpClient.get<Adresse>(`${this.WS_REST_BASE_URL}/findById/${pAdresseId}`);

  }//end getAdresseByIdFromWsRest


  modifierAdresseViaWsRest(pAdresse:Adresse): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pAdresse.idAdresse, pAdresse );

  }//end modifierAdresseViaWsRest

}//end classe