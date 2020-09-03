import { Component, OnInit } from '@angular/core';
import {BiensImmobiliersService} from 'src/app/services/biens-immobiliers.service';
import {BienImmobilier} from 'src/app/modèles/BienImmobilier';
import {Adresse} from 'src/app/modèles/Adresse';
import { Router, ActivatedRoute } from '@angular/router';



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


  deleteBienImmo(bienImmobilier:BienImmobilier){

    this.biensImmoService.supprimerBienImmoViaWsRest(bienImmobilier).subscribe( ()=>{

      this.findAllBiensImmo();
    });

  }//end deleteBienImmo


  editBienImmo(idBienImmobilier :number){

    this.route.navigate(['listBiens/edit', idBienImmobilier]);

  }//end editBienImmo

  /**
   * Méthode pour renvoyer le bien immobilier vers une nouvelle page html avec les détails associés
   */
  detailsBienImmo(IdbienImmobilier: number){

    
    this.route.navigate(['bienImmo', IdbienImmobilier]);

  }//end detailsBienImmo
 

  attribuerAdresse(pIdBienImmobilier){
    console.log("bonjour on est dans attribution d'adresse !!" + pIdBienImmobilier);

    this.route.navigate(['adresses/edit', 0]);
    
  }

}//end class