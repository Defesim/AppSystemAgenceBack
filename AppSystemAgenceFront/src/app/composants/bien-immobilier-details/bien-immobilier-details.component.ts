import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { BienImmobilier } from 'src/app/modèles/BienImmobilier';
import { Proprietaire } from 'src/app/modèles/Proprietaire'
import { ProprietairesService } from 'src/app/services/proprietaires.service'

@Component({
  selector: 'app-bien-immobilier-details',
  templateUrl: './bien-immobilier-details.component.html',
  styleUrls: ['./bien-immobilier-details.component.css']
})
export class BienImmobilierDetailsComponent implements OnInit {

  /*_______ PROPS_____*/
  bienImmo: BienImmobilier;

  /*_______ CTOR ______*/
  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private bienImmobilierServicer: BiensImmobiliersService,
    private proprietairesService: ProprietairesService
  ) {

  }//end ctor

  /*_______ METHODES ______*/
  /**
   * Méthode exécutée à l'initiation
   */
  ngOnInit(): void {

    /**
     * Récupération du paramètre 'bien' de
     */
    this.activatedRouter.paramMap.subscribe(
      (paramsMap) => {

        const idBien = +paramsMap.get("id");
        this.findBienImmoById(idBien);

      }
    )
  }//end ngOnInit

  findBienImmoById(idBien: number) {

    this.bienImmobilierServicer.getBienImmoByIdFromWsRest(idBien).subscribe(

      (bienToUpdate) => {
        this.bienImmo = bienToUpdate;
      }
    );

  }//end findBienImmoById


  attribuerAdresse(pIdBienImmobilier){
    console.log("bonjour on est dans attribution d'adresse !!" + pIdBienImmobilier);

    this.router.navigate(['adresses/edit',0]);
    
  }



  acquerirBienImmo(idBien: number){


    this.router.navigate(['acquisition',  idBien]);

  }//end acquerirBienImmo


  retourVersListeBien(){

    this.router.navigate(['/listBiens']);

  }//end acquerirBienImmo

}//end class
