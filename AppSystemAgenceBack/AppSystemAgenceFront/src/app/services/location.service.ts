import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {Location} from 'src/app/modèles/Location';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class LocationService {

  private WS_REST_BASE_URL = "http://localhost:8080/AppSystemAgenceBack/locations";


  constructor(private httpClient: HttpClient) { }


  getAllLocationFromWsRest(): Observable<Location[]>{
    return this.httpClient.get<Location[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllLocationFromWsRest

  ajouterLocationViaWsRest(location: Location): Observable<Location>{

    return this.httpClient.post<Location>(this.WS_REST_BASE_URL+"/save", location);

  }

  supprimerLocationViaWsRest(location:Location): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + location.idModeOffre);

  }//end supprimerLocationViaWsRest

  getLocationByIdFromWsRest(pLocationId : number): Observable<Location>{

    return this.httpClient.get<Location>(`${this.WS_REST_BASE_URL}/findById/${pLocationId}`);

  }//end getLocationByIdFromWsRest


  modifierLocationViaWsRest(pLocation:Location): Observable<void>{

    return this.httpClient.put<void>(this.WS_REST_BASE_URL + "/update/" +pLocation.idModeOffre, pLocation );

  }//end modifierLocationViaWsRest

}//end classe
