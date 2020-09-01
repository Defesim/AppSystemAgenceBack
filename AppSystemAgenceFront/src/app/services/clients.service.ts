import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {Client} from 'src/app/modèles/Client';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {


  private WS_REST_BASE_URL = "http://localhost:8080/gestion-agence-immo/ws-rest/clients";


  constructor(private httpClient: HttpClient) { }


  getAllClientFromWsRest(): Observable<Client[]>{
    return this.httpClient.get<Client[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllClientFromWsRest

  ajouterClientViaWsRest(client: Client): Observable<Client>{

    return this.httpClient.post<Client>(this.WS_REST_BASE_URL+"/save", client);

  }

  supprimerClientViaWsRest(pClient:Client): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + pClient.id_personne);

  }//end supprimerEmployeViaWsRest

  getClientByIdFromWsRest(pPersonneId : number): Observable<Client>{

    return this.httpClient.get<Client>(`${this.WS_REST_BASE_URL}/get-by-id/${pPersonneId}`);

  }//end getEmployeByIdFromWsRest


  modifierClientViaWsRest(pClient:Client): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pClient.id_personne, pClient );

  }//end modifierEmployeViaWsRest

}//end classe
