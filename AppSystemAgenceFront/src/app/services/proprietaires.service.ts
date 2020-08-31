import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {Proprietaire} from 'src/app/modèles/Proprietaire';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProprietairesService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/proprietaires";


  constructor(private httpClient: HttpClient) { }


  getAllProprietaireFromWsRest(): Observable<Proprietaire[]>{
    return this.httpClient.get<Proprietaire[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllProprietaireFromWsRest

  ajouterProprietaireViaWsRest(proprietaire: Proprietaire): Observable<Proprietaire>{

    return this.httpClient.post<Proprietaire>(this.WS_REST_BASE_URL+"/save", proprietaire);

  }

  supprimerProprietaireViaWsRest(proprietaire:Proprietaire): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + proprietaire.id_personne);

  }//end supprimerProprietaireViaWsRest

  getProprietaireByIdFromWsRest(pProprietaireId : number): Observable<Proprietaire>{

    return this.httpClient.get<Proprietaire>(`${this.WS_REST_BASE_URL}/findById/${pProprietaireId}`);

  }//end getProprietaireByIdFromWsRest


  modifierProprietaireViaWsRest(pProprietaire:Proprietaire): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pProprietaire.id_personne, pProprietaire );

  }//end modifierProprietaireViaWsRest

}//end classe
