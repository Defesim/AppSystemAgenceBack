import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {AgentImmobilier} from 'src/app/modèles/AgentImmobilier';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AgentsService {

  private WS_REST_BASE_URL = "http://localhost:8080/gestion-agence-immo/ws-rest/agentImmobilier";


  constructor(private httpClient: HttpClient) { }


  getAllAgentImmobilierFromWsRest(): Observable<AgentImmobilier[]>{
    return this.httpClient.get<AgentImmobilier[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllAgentImmobilierFromWsRest

  ajouterAgentImmobilierViaWsRest(agentImmobilier: AgentImmobilier): Observable<AgentImmobilier>{

    return this.httpClient.post<AgentImmobilier>(this.WS_REST_BASE_URL+"/save", agentImmobilier);

  }

  supprimerAgentImmobilierViaWsRest(agentImmobilier:AgentImmobilier): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + agentImmobilier.id_personne);

  }//end supprimerAgentImmobilierViaWsRest

  getAgentImmobilierByIdFromWsRest(pAgentImmobilierId : number): Observable<AgentImmobilier>{

    return this.httpClient.get<AgentImmobilier>(`${this.WS_REST_BASE_URL}/get-by-id/${pAgentImmobilierId}`);

  }//end getAgentImmobilierByIdFromWsRest


  modifierAgentImmobilierViaWsRest(pAgentImmobilier:AgentImmobilier): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pAgentImmobilier.id_personne, pAgentImmobilier );

  }//end modifierAgentImmobilierViaWsRest

}//end classe