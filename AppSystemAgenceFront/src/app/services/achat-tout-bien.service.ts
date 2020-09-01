import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {AchatToutBien} from 'src/app/modèles/AchatToutBien';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AchatToutBienService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/achat-tout-biens";


  constructor(private httpClient: HttpClient) { }


  getAllAchatToutBienFromWsRest(): Observable<AchatToutBien[]>{
    return this.httpClient.get<AchatToutBien[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllAchatToutBienFromWsRest

  ajouterAchatToutBienViaWsRest(achatToutBien: AchatToutBien): Observable<AchatToutBien>{

    return this.httpClient.post<AchatToutBien>(this.WS_REST_BASE_URL+"/save", achatToutBien);

  }

  supprimerAchatToutBienViaWsRest(achatToutBien:AchatToutBien): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + achatToutBien.idModeOffre);

  }//end supprimerAchatToutBienViaWsRest

  getAchatToutBienByIdFromWsRest(pAchatToutBienId : number): Observable<AchatToutBien>{

    return this.httpClient.get<AchatToutBien>(`${this.WS_REST_BASE_URL}/findById/${pAchatToutBienId}`);

  }//end getAchatToutBienByIdFromWsRest


  modifierAchatToutBienViaWsRest(pAchatToutBien:AchatToutBien): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pAchatToutBien.idModeOffre, pAchatToutBien );

  }//end modifierAchatToutBienViaWsRest

}//end classe