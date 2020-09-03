import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {ClasseStandard} from 'src/app/modèles/ClasseStandard';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClassesStandardsService {

  private WS_REST_BASE_URL = "http://localhost:8080/gestion-agence-immo/classeStandard";


  constructor(private httpClient: HttpClient) { }


  getAllClasseStandardFromWsRest(): Observable<ClasseStandard[]>{
    return this.httpClient.get<ClasseStandard[]>(this.WS_REST_BASE_URL + "/getAll");
  }//end getAllClasseStandardFromWsRest

  ajouterClasseStdViaWsRest(classeStandard: ClasseStandard): Observable<ClasseStandard>{

    return this.httpClient.post<ClasseStandard>(this.WS_REST_BASE_URL+"/save", classeStandard);

  }

  supprimerClasseStdViaWsRest(pClasseStandard:ClasseStandard): Observable<void>{

    return this.httpClient.delete<void>(this.WS_REST_BASE_URL + "/delete/" + pClasseStandard.idClasseStandard);

  }//end supprimerClasseStdViaWsRest

  getClasseStdByIdFromWsRest(pClasse : number): Observable<ClasseStandard>{

    return this.httpClient.get<ClasseStandard>(`${this.WS_REST_BASE_URL}/findById/${pClasse}`);

  }//end getClasseStdByIdFromWsRest


  modifierClasseStdViaWsRest(pClasseStandard:ClasseStandard): Observable<ClasseStandard>{

    return this.httpClient.put<ClasseStandard>(this.WS_REST_BASE_URL + "/update/" , pClasseStandard );

  }//end modifierClasseStdViaWsRest

}//end classe
