import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {AchatSaufTerrain} from 'src/app/modèles/AchatSaufTerrain';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AchatSaufTerrainService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/achat-sauf-terrains";


  constructor(private httpClient: HttpClient) { }


  getAllAchatSaufTerrainFromWsRest(): Observable<AchatSaufTerrain[]>{
    return this.httpClient.get<AchatSaufTerrain[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllAchatSaufTerrainFromWsRest

  ajouterAchatSaufTerrainViaWsRest(achatSaufTerrain: AchatSaufTerrain): Observable<AchatSaufTerrain>{

    return this.httpClient.post<AchatSaufTerrain>(this.WS_REST_BASE_URL+"/save", achatSaufTerrain);

  }

  supprimerAchatSaufTerrainViaWsRest(achatSaufTerrain:AchatSaufTerrain): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + achatSaufTerrain.idModeOffre);

  }//end supprimerAchatSaufTerrainViaWsRest

  getAchatSaufTerrainByIdFromWsRest(pAchatSaufTerrainId : number): Observable<AchatSaufTerrain>{

    return this.httpClient.get<AchatSaufTerrain>(`${this.WS_REST_BASE_URL}/findById/${pAchatSaufTerrainId}`);

  }//end getAchatSaufTerrainByIdFromWsRest


  modifierAchatSaufTerrainViaWsRest(pAchatSaufTerrain:AchatSaufTerrain): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pAchatSaufTerrain.idModeOffre, pAchatSaufTerrain );

  }//end modifierAchatSaufTerrainViaWsRest

}//end classe