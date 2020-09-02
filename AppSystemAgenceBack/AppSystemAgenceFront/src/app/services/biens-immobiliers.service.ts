import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {BienImmobilier} from 'src/app/modèles/BienImmobilier';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BiensImmobiliersService {

  private WS_REST_BASE_URL = "http://localhost:8080/gestion-agence-immo/biensImmo";

  constructor(private httpClient: HttpClient) { }


  getAllBienImmoFromWsRest(): Observable<BienImmobilier[]>{
    return this.httpClient.get<BienImmobilier[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllBienImmoFromWsRest

  ajouterBienImmoViaWsRest(bienImmo: BienImmobilier): Observable<BienImmobilier>{

    return this.httpClient.post<BienImmobilier>(this.WS_REST_BASE_URL+"/save", bienImmo);

  }

  supprimerBienImmoViaWsRest(bienImmo:BienImmobilier): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + bienImmo.idBienImmobilier);

  }//end supprimerBienImmoViaWsRest

  getBienImmoByIdFromWsRest(pBienId : number): Observable<BienImmobilier>{

    return this.httpClient.get<BienImmobilier>(`${this.WS_REST_BASE_URL}/findById/${pBienId}`);

  }//end getBienImmoByIdFromWsRest


  modifierBienImmoViaWsRest(pBien:BienImmobilier): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update", pBien ); /*+pBien.idBienImmobilier, pBien );*/

  }//end modifierBienImmoViaWsRest

}//end classe