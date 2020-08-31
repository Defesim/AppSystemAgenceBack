import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {Visite} from 'src/app/modèles/Visite';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class VisitesService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/biensImmo";


  constructor(private httpClient: HttpClient) { }


  getAllVisiteFromWsRest(): Observable<Visite[]>{
    return this.httpClient.get<Visite[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllVisiteFromWsRest

  ajouterVisiteViaWsRest(visite: Visite): Observable<Visite>{

    return this.httpClient.post<Visite>(this.WS_REST_BASE_URL+"/save", visite);

  }

  supprimerVisiteViaWsRest(visite:Visite): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + visite.idVisite);

  }//end supprimerVisiteViaWsRest

  getVisiteByIdFromWsRest(pVisiteId : number): Observable<Visite>{

    return this.httpClient.get<Visite>(`${this.WS_REST_BASE_URL}/findById/${pVisiteId}`);

  }//end getVisiteByIdFromWsRest


  modifierVisiteViaWsRest(pVisite:Visite): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pVisite.idVisite, pVisite );

  }//end modifierVisiteViaWsRest

}//end classe