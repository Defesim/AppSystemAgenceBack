import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {Acquisition} from 'src/app/modèles/Acquisition';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AcquisitionsService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/acquisition";


  constructor(private httpClient: HttpClient) { }


  getAllAcquisitionFromWsRest(): Observable<Acquisition[]>{
    return this.httpClient.get<Acquisition[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllAcquisitionFromWsRest

  ajouterAcquisitionViaWsRest(acquisition: Acquisition): Observable<Acquisition>{

    return this.httpClient.post<Acquisition>(this.WS_REST_BASE_URL+"/save", acquisition);

  }

  supprimerAcquisitionViaWsRest(acquisition:Acquisition): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + acquisition.idAcquisition);

  }//end supprimerAcquisitionViaWsRest

  getAcquisitionByIdFromWsRest(pAcquisitionId : number): Observable<Acquisition>{

    return this.httpClient.get<Acquisition>(`${this.WS_REST_BASE_URL}/findById/${pAcquisitionId}`);

  }//end getAcquisitionByIdFromWsRest


  modifierAcquisitionViaWsRest(pAcquisition:Acquisition): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pAcquisition.idAcquisition, pAcquisition );

  }//end modifierAcquisitionViaWsRest

}//end classe
