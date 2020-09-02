import { Component, OnInit } from '@angular/core';
import { AdressesService } from 'src/app/services/adresses.service';
import { Router } from '@angular/router';
import { Adresse } from 'src/app/modèles/Adresse';

@Component({
  selector: 'app-adresses',
  templateUrl: './adresses.component.html',
  styleUrls: ['./adresses.component.css']
})
export class AdressesComponent implements OnInit {

  //var de stockage de tous les biens immo
  adresses =[];

  constructor(private adresseService: AdressesService, private route:Router) {
    this.findAllBiensImmo();

   }//end ctor

  ngOnInit(): void {
  }//end ngOnInit


  findAllBiensImmo(){
    this.adresseService.getAllAdresseFromWsRest()
                         .subscribe(data=> this.adresses = data);
  }//end findAllBiensImmo


  deleteAdresse(adresse:Adresse){

    this.adresseService.supprimerAdresseViaWsRest(adresse).subscribe( ()=>{

      this.findAllBiensImmo();
    });

  }//end deleteAdresse


  editAdresse(idAdresse :number){

    this.route.navigate(['adresses/edit', idAdresse]);

  }//end editAdresse
 

}//end class
