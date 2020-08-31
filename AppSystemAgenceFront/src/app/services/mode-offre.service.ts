import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {ModeOffre} from 'src/app/modèles/ModeOffre';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModeOffreService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/mode-offre";


  constructor(private httpClient: HttpClient) { }


  getAllModeOffreFromWsRest(): Observable<ModeOffre[]>{
    return this.httpClient.get<ModeOffre[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllModeOffreFromWsRest

  ajouterModeOffreViaWsRest(modeOffre: ModeOffre): Observable<ModeOffre>{

    return this.httpClient.post<ModeOffre>(this.WS_REST_BASE_URL+"/save", modeOffre);

  }

  supprimerModeOffreViaWsRest(modeOffre:ModeOffre): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + modeOffre.idModeOffre);

  }//end supprimerModeOffreViaWsRest

  getModeOffreByIdFromWsRest(pModeOffreId : number): Observable<ModeOffre>{

    return this.httpClient.get<ModeOffre>(`${this.WS_REST_BASE_URL}/findById/${pModeOffreId}`);

  }//end getModeOffreByIdFromWsRest


  modifierModeOffreViaWsRest(pModeOffre:ModeOffre): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pModeOffre.idModeOffre, pModeOffre );

  }//end modifierModeOffreViaWsRest

}//end classe
