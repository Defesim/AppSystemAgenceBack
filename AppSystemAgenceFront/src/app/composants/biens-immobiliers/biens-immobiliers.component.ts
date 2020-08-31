import { Component, OnInit } from '@angular/core';
import {BiensImmobiliersService} from 'src/app/services/biens-immobiliers.service';
import {BienImmobilier} from 'src/app/modèles/BienImmobilier';
import {Adresse} from 'src/app/modèles/Adresse';
import { Router } from '@angular/router';



@Component({
  selector: 'app-biens-immobiliers',
  templateUrl: './biens-immobiliers.component.html',
  styleUrls: ['./biens-immobiliers.component.css']
})

export class BiensImmobiliersComponent implements OnInit {

  //var de stockage de tous les biens immo
  biensImmobiliers =[];

  constructor(private biensImmoService: BiensImmobiliersService, private route:Router) {
    this.findAllBiensImmo();

   }//end ctor

  ngOnInit(): void {
  }//end ngOnInit


  findAllBiensImmo(){
    this.biensImmoService.getAllBienImmoFromWsRest()
                         .subscribe(data=> this.biensImmobiliers = data);
  }//end findAllBiensImmo

}