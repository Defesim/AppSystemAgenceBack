import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {VisitesService} from 'src/app/services/visites.service';
import { Visite } from 'src/app/modèles/Visite';

@Component({
  selector: 'app-visites',
  templateUrl: './visites.component.html',
  styleUrls: ['./visites.component.css']
})
export class VisitesComponent implements OnInit {

  /*__________________props_______________ */
  visites =[] ;


  constructor(private visiteService: VisitesService,
              private route:Router) {
      this.findAllVisites();
   }//end ctors


  ngOnInit(): void {
  }//end ngOnInit


  findAllVisites(){
    this.visiteService.getAllVisiteFromWsRest()
                      .subscribe(data=> this.visites = data);
  }//end findAllBiensImmo


  deleteVisite(visite:Visite){
    
    this.visiteService.supprimerVisiteViaWsRest(visite).subscribe( ()=>{

      this.findAllVisites();
    });

  }//end deleteVisite


  editVisite(idVisite :number){

    this.route.navigate(['visites/edit', idVisite]);

  }//end editVisite
   

}//end class
